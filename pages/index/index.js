// pages/index_address/index_address.js
const app = getApp();
Page({
  data: {
    
  },

  login_citizen: function() {
    wx.navigateTo({
      url: '../login_citizen/login_citizen',
    });
  },

  login_staff: function() {
    wx.navigateTo({
      url: '../login_staff/login_staff',
    });
  },

  onLoad: function (options) {

  },
})