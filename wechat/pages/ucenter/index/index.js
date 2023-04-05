var util = require('../../../utils/util.js');
var api = require('../../../config/api.js');

var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {
      nickName: '点击登录',
      avatarUrl: '/static/images/my.png'
    },
    hasLogin:false,
    elements:[{title:"个人资料",url:"../info/info"},
    {title:"我的视频",url:"../video/video"},
    {title:"我的帖子",url:"../text/text"},
    {title:"分享邀请",url:"../share/share"}]
  },
  goLogin(){
    
    if(!this.data.hasLogin){
      wx.navigateTo({
        url: '/pages/auth/login/login',
      });
    }
  },
  
  handletap:function(e){
    this.goLogin();
    wx.navigateTo({
      url: this.data.elements[e.target.dataset.idx].url+'?userid='+wx.getStorageSync('skey')
    })
  },
  onShow:function(){
    if (app.globalData.hasLogin) {
      let userInfo = wx.getStorageSync('userInfo');
      this.setData({
        userInfo: userInfo,
        hasLogin: true
      });

      let that = this;
      util.request(api.UserIndex).then(function(res) {
        if (res.errno === 0) {
          that.setData({
            order: res.data.order
          });
        }
      });
    }

  }
})