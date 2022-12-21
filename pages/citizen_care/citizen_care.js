// pages/citizen_care/citizen_care.js
// pages/citizen/citizen.js
var util_s = require('../../utils/util_s.js');
const app = getApp();
Page({
  data: {
    id: '',
  },

  onLoad: function (options) {
    var that = this;
    // get init brightness
    let id =app.globalData.username;
    wx.request({
      url: 'http://localhost:8080/user/citizen/searchCitizen',
      data:{"id":id},
      method: 'Post',  //方法分GET和POST，根据需要写
      header: { "content-type": "application/x-www-form-urlencoded", "x-requested-with": "XMLHttpRequest" },
      complete:function(res){
        console.log(res.data);//调出来的数据在控制台显示，方便查看
        that.setData({
          citizens: res.data
        })
      },
      success: function (res) {//这里写调用接口成功之后所运行的函数
        console.log("请求成功")
      },
      fail: function (res) {//这里写调用接口失败之后所运行的函数
        console.log('.........fail..........');
      }
    })

    wx.getScreenBrightness({
      success: function (res) { that.setData({ ScreenBrightness: res.value }) }
    })
    wx.setScreenBrightness({ value: 1 })
    // update time every second
    setInterval(function () {
      that.setData({
        Time: util_s.formatTime(new Date()),
        Time_s: util_s.formatTime_s(new Date())
      });
    }, 1000);
  },
  

  // 记录触摸起点
  touchStart(e) {
    var that = this;
    that.setData({
      touchx: e.changedTouches[0].clientX,
      touchy: e.changedTouches[0].clientY,
    })
  },

  touchEnd(e) {
    var that = this;
    let x = e.changedTouches[0].clientX;
    let y = e.changedTouches[0].clientY;
    let turn = "";
    if (x - that.data.touchx > 50 && Math.abs(y - that.data.touchy) < 50) {      //右滑
      turn = "right"
    } else if (x - that.data.touchx < -50 && Math.abs(y - that.data.touchy) < 50) {   //左滑
      turn = "left";
    }
    //根据方向进行操作
    if (turn == 'left') {
      wx.navigateTo({
        url: '../index_adress/index_adress',
      });
    }
  },
  // set brightness to init
  onUnload: function () {
    wx.setScreenBrightness({ value: this.data.ScreenBrightness })
  },

  jump:function(e){
    console.log(e);
    let url = e.currentTarget.dataset.url;

    wx.navigateTo({
      url
    })
  }
})