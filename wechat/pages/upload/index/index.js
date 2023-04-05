const util = require("../../../utils/util")
const api = require("../../../config/api")

const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    hasLogin:false,
    topics:[],
  },

  onLoad:function(){
    let that = this
    util.request(api.TopicName,{
      typeID:0
    }).then(function(res) {
      if (res.errno == 0) {
        that.setData({
          topics:res.data.topics
        })
      }
    })
    if (app.globalData.hasLogin) {
      this.setData({
        hasLogin: true
      });
    }
    this.goLogin();
  },
  uploadvideo:function(e){
    let that = this;
    wx.navigateTo({
      url: '../video/video'
    })
  },
  uploadtext:function(e){
    let that=this
    wx.showActionSheet({
        itemList:that.data.topics,
        success:function(res){
          let topicName = that.data.topics[res.tapIndex]
          console.log(topicName)
          wx.navigateTo({
            url: '../text/text?topicName='+topicName,
          })
        }
      })
    },
    goLogin(){
      
      if(!this.data.hasLogin){
        wx.navigateTo({
          url: '/pages/auth/login/login',
        });
      }
    },
  
})