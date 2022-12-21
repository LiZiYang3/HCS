// pages/register/register.js
var util_s = require('../../utils/util_s.js');
const app = getApp();
Page({
  //  页面的初始数据
  data: {
    name: '',
    id: '',
    password: '',
    password_again: '',
    isRegister: true,
  },


  userNameInput:function(e){
    
    this.setData({
      name: e.detail.value
    })
  },
  idInput:function(e){
    
    this.setData({
      id: e.detail.value
    })
  },

  passwordInput:function(e){
    
    this.setData({
      password: e.detail.value
    })
  },

  passwordAgainInput:function(e){
    
    this.setData({
      password_again: e.detail.value
    })
  },

  register: function (e) {

    if (this.data.name == '') {
      wx.showToast({
        title: '请输入姓名',
        icon: 'error',
        duration: 2000
      })
      return
    } 
    else if (this.data.id=='') {
      wx.showToast({
        title: '请输入身份证号',
        icon: 'error',
        duration: 2000
      })
      return
    }
    else if (this.data.password=='') {
      wx.showToast({
        title: '请输入密码',
        icon: 'error',
        duration: 2000
      })
      return
    } 
    else if (this.data.password_again=='') {
      wx.showToast({
        title: '请再次输入密码',
        icon: 'error',
        duration: 2000
      })
      return
    }
    else if (this.data.password_again!=this.data.password) {
      wx.showToast({
        title: '两次密码不一致',
        icon: 'error',
        duration: 2000
      })
      return
    }
    else {
      var that = this;
      var name = this.data.name;
      var id = this.data.id;
      var phone = this.data.phone;
      var password = this.data.password;
      var registerNum = 0;
      wx.request({
        url: 'http://localhost:8080/user/staff/searchstaff',
        data:{"id":id},
        method:"POST",
        header: { "content-type": "application/x-www-form-urlencoded", "x-requested-with": "XMLHttpRequest" },
        success:(res)=>{
          console.log("[login]从服务器收到的查询结果是："+JSON.stringify(res));
          registerNum=res.data.length;
          console.log(registerNum+'这里是第零处');
          console.log(registerNum == 0);
          if (registerNum==0){
            wx.request({
              url: 'http://localhost:8080/user/staff/addstaff',
              data:{"sid":id, "name":name, "password":password},
              method:"GET",
              header: { "content-type": "application/json" },
              success:(res)=>{
                console.log("[login]从服务器收到的查询结果是："+JSON.stringify(res));
                console.log(registerNum+'这里是第二处');
                wx.showToast({
                  title: '您已注册成功',
                  icon: 'success',
                  duration: 2000
                }),
                wx.navigateTo({
                  url: '../login_staff/login_staff',
                })
                
              },
              fail:(res)=>{//这里写调用接口失败之后所运行的函数
                console.log('注册新增市民失败');
                console.log(registerNum+'这里是第二处');
              },
            })
          }
          else if (registerNum!=0){
            wx.showToast({
              title: '身份证已被注册',
              icon: 'error',
              duration: 2000
            })
          }
        },
        fail:(res)=>{//这里写调用接口失败之后所运行的函数
          console.log('注册检测人员信息失败');
        },
      })
      console.log(registerNum+'这里是第一处')
    }
  },

  exit: function (e) {
    wx.navigateBack({
      delta: 1,
    })
  },

  onLoad: function (e) {
    
  },
})