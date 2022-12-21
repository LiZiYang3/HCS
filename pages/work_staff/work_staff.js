// pages/work_staff/work_staff.js
var util = require('../../utils/util_s.js');
const app = getApp();
Page({
  //  页面的初始数据
  data:{
    show:"",
    sfz:null,
    sidList:[],
  },
  onLoad: function () {
    this.getsid();
  },
  exit: function (e) { //返回函数
    wx.navigateBack({
      delta: 1,
    })
  },
  getsid:function(e){   //获取市民数据
    let that=this;
    let tid=app.globalData.tub_id;
    // console.log(userid);
    wx.request({
      url: 'http://localhost:8080/detection/detectionresult/searchDetectionResult2',
      data:{"tid":tid},
      header: { "content-type": "application/x-www-form-urlencoded", "x-requested-with": "XMLHttpRequest" },
      success:function(res){
        console.log("[onDeviceListTap]从服务器收到的查询结果是："+JSON.stringify(res.data));
        that.setsid(res.data);
      }
    })
  },
  setsid:function(data){  //填充数据
    let _this = this;
    wx.showToast({
      title: '加载中',
      icon: 'loading'
    })
    const newlist = [];
    for (var i =0; i <data.length; i++) {
      newlist.push({
        "id":i+1,
        "sid":data[i].id
      })
    }
    setTimeout(()=>{
      _this.setData({
        sidList:_this.data.sidList.concat(newlist)
      })
    },1500)
  },
  sfz:function(e){   //获得身份证号码
    let sfz=e.detail.value;
    this.setData({
      "sfz":sfz
    })
  },
  add:function(e){    //添加核酸检测信息
    let that=this
    if(app.globalData.max==0){
      wx.showToast({
        title: '试管已满',
        icon: 'error',
        duration: 2000
      })
    }else{
      let sid=app.globalData.username;
      let sfz=that.data.sfz;
      let tid=app.globalData.tub_id;
      wx.request({
        url: 'http://localhost:8080/detection/detectionresult/addDetectionResult',
        data:{"id":sfz,"sid":sid,"tid":tid},
        header: { "content-type": "application/x-www-form-urlencoded", "x-requested-with": "XMLHttpRequest", "Cookie": "JSESSIONID=84a91085-b05b-4c3c-b8cc-318e3eea4530" },
        success:(res)=>{
          // console.log("从服务器收到的查询结果是："+JSON.stringify(res.data));
          that.setData({
            sidList:[],
            sfz:null,
          })
          getApp().globalData.max=app.globalData.max-1;
          console.log(getApp().globalData.max);
          that.getsid();
          wx.showToast({
            title: '成功',
            icon: 'success',
            duration: 2000
          })
        },
        fail: (res) => {
          wx.showToast({
            title: '失败',
            icon: 'error',
            duration: 2000
          })
        },
      })
    }
  },
  scan:function(e){   //扫描二维码
    let that=this;
    var show;
    wx.scanCode({
      success:(res)=>{
        show = res.result;
        console.log(res.result);
        that.setData({
         sfz: show
        })
        wx.showToast({
         title: '成功',
         icon: 'success',
         duration: 2000
        })
      },
      fail: (res) => {
        wx.showToast({
         title: '失败',
         icon: 'fail',
         duration: 2000
        })
      }, 
    })
  },
  submit:function(e){
    getApp().globalData.tub_id=null;
    getApp().globalData.max=null;
    wx.navigateTo({
      url: '../add_tube/add_tube',
    })
  },

})