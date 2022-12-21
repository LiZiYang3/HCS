// pages/login_citizen/login_citizen.js
var util_s = require('../../utils/util_s.js');
const app = getApp();
Page({
  //  页面的初始数据
  data: {
    username:null,
    password:null,
    defaultType:true, //眼睛状态
    passwordType:true,  //密码是否可见
  },
  eyeStatus:function(e){
    this.data.defaultType=!this.data.defaultType
    this.data.passwordType=!this.data.passwordType
    this.setData({
      defaultType:this.data.defaultType,
      passwordType:this.data.passwordType
    })
  },
  userNameInput:function(e){
    this.setData({
      "username":e.detail.value
    })
  },
  passWdInput:function(e){
    this.setData({
      "password":e.detail.value
    })
  },
  login:function(){
    let username=this.data.username;
    let password = this.data.password;
    console.log(username);
    wx.request({
      url: 'http://localhost:8080/user/citizen/searchCitizen',
      data:{"id":username},
      method:"POST",
      header: { "content-type": "application/x-www-form-urlencoded", "x-requested-with": "XMLHttpRequest" },
      success:(res)=>{
        console.log("[login]从服务器收到的查询结果是："+JSON.stringify(res));
        if(res.data.length>0){
          if(res.data[0].password==password){
             wx.navigateTo({
              url: '../citizen/citizen',
            });
            getApp().globalData.username=username;
          }else if(res.data[0].password!=password){
            wx.showToast({
              title: '密码错误',
              icon:'error',
              duration: 2000
             })
          }
        }else{
          wx.showToast({
            title: '用户名错误',
            icon: 'error',
            duration: 2000
           })
        }
      },
    })
  },

  register: function (e) {
    wx.navigateTo({
      url: '../register_citizen/register_citizen',
    })
  },

  exit: function (e) {
    wx.navigateTo({
      url: '../index/index',
    })
  },
  onLoad: function () {
    
  },


})