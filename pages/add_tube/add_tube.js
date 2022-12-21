// pages/add_tube/add_tube.js
var util = require('../../utils/util_s.js');
const app = getApp();
Page({

  data: {
    time:null,
    time_s:null,
    tub_id:null,
    max:null,
    sid:null,
  },

  onLoad:function() {
    this.setData({
      sid:app.globalData.username
    })
    var TIME = util.formatTime(new Date());
    var TIME_S =util.formatTime_s(new Date());
    this.setData({
      time: TIME,
      time_s:TIME_S
      });
  },
  id:function(e){
    this.setData({
      "tub_id":e.detail.value
    })
  },
  max:function(e){
    this.setData({
      "max":e.detail.value
    })
  },
  add:function(e){
    if(app.globalData.tub_id==null){
      let that=this;
      let tub_id=that.data.tub_id;
      let max = that.data.max;
      let time=that.data.time+that.data.time_s;
      let sid=that.data.sid;
      console.log(sid);
      wx.request({
        url: 'http://localhost:8080/detection/testtube/addTube',
        data:{"id":tub_id,"sid":sid,"max":max,"time":time},
        method:"POST",
        header: { "content-type": "application/x-www-form-urlencoded", "Cookie": "JSESSIONID=84a91085-b05b-4c3c-b8cc-318e3eea4530"},
        success:(res)=>{
          console.log("[add]从服务器收到的查询结果是："+JSON.stringify(res));
          if(res.data.msg=='操作成功'){
              wx.navigateTo({
                url: '../work_staff/work_staff',
              })
              getApp().globalData.tub_id=tub_id;
              getApp().globalData.max=max;
          }else{
            wx.showToast({
              title: '失败',
              icon:'error',
              duration: 2000
             })
          }
        
        },
      })
    }else{
      wx.showToast({
        title: '试管未提交',
        icon:'error',
        duration: 2000
       })
    }
  },
  view:function(e){
    if(app.globalData.tub_id!=null){
      wx.navigateTo({
        url: '../work_staff/work_staff',
      })
    }else{
      wx.showToast({
        title: '没有未提交试管',
        icon:'error',
        duration: 2000
       })
    }
  },

  exit:function(e){
    getApp().globalData.username=null;
    wx.navigateTo({
      url: '../login_staff/login_staff',
    })
  },

})