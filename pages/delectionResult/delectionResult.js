// pages/delectionResult/delectionResult.js
var util_s = require('../../utils/util_s.js');
const app = getApp()

Page({
  data: {
  },

  save_address: function (e) {
    var pages = getCurrentPages();
    var currPage = pages[pages.length - 1];   //当前页面
    var prevPage = pages[pages.length - 2];  //上一个页面
    if (this.data.checked_address == -1) {
      return
    }
    prevPage.setData({
      ["title"]: this.data.title_list[this.data.checked_address],
      ["address"]: this.data.address_list[this.data.checked_address],
      ["default_address"]: false
    })
    wx.navigateBack({
      delta: 1,
    })
  },

  exit: function (e) {
    wx.navigateBack({
      delta: 1,
    })
  },
  onLoad: function (query) {
    var that = this;
    let id =app.globalData.username;
    wx.request({
      url: 'http://localhost:8080/detection/detectionresult/searchDetectionResult',
      data:{"id": id},
      method: 'Post',  //方法分GET和POST，根据需要写
      header: { "content-type": "application/x-www-form-urlencoded", "x-requested-with": "XMLHttpRequest" },
      complete:function(res){
        console.log(res.data);//调出来的数据在控制台显示，方便查看
        that.setData({
          detectionResults: res.data
        })
      },


      success: function (res) {//这里写调用接口成功之后所运行的函数
        console.log(res.data)
        
      },
      fail: function (res) {//这里写调用接口失败之后所运行的函数
        console.log('.........fail..........');
      }
    })

    

    

    
  },
  

})


