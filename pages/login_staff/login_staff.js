// pages/login_staff/login_staff.js
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
  onLoad: function () {
    
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
    wx.request({
      url: 'http://localhost:8080/user/staff/searchstaff',
      data:{"id":username},
      method:"POST",
      header: { "content-type": "application/x-www-form-urlencoded", "x-requested-with": "XMLHttpRequest" },
      success:(res)=>{
        console.log("[login]从服务器收到的查询结果是："+JSON.stringify(res.data));
        if(res.data.length>0){
          if(res.data[0].password==password){
             wx.navigateTo({
              url: '../add_tube/add_tube',
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
      url: '../register_staff/register_staff',
    })
  },

  exit: function (e) {  //返回函数
    wx.navigateTo({
      url: '../index/index',
    })
  },


})