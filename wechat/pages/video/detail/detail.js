// pages/video/detail/detail.js
const util = require('../../../utils/util');
const api = require('../../../config/api');

const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id:0,
    video:{},
    comments:[],
    showflag:true,
  },
  onLoad:function(options) {
    if(options.id){
      this.setData({
        id:parseInt(options.id)
      });
      this.getVideoDetail();
    }
  },
  showChange:function(e){
    this.setData({
      showflag:!this.data.showflag
    })
  },
  getVideoDetail:function(){
    let that = this;
    util.request(api.VideoDetail,{
      videoID:that.data.id
    }).then(function(res){
      if(res.errno===0){
        res.data.video.path="pages/video/detail/detail?videoID="+that.data.id
        that.setData({
            video:res.data.video,
            comments:res.data.comments
        })
      }
    });
  },
  postComment(){
    var that=this;
    if (!app.globalData.hasLogin) {
      wx.navigateTo({
        url: "/pages/auth/login/login"
      });
    } else {
      wx.showModal({
        editable:true,
        placeholderText:'评论千万条，友善第一条',//借鉴知乎的
        success:function(res){
          if(res.confirm){
            if(res.content&&res.content.length>140){
              return false;
            }
            util.request(api.CommentPost,{
              type:1,
              typeID:that.data.video.videoID,
              userID:wx.getStorageSync('skey'),
              commentContent:res.content
            },'Post').then(function(res){
              if (res.errno === 0) {
                wx.showToast({
                  title: '评论成功',
                  icon: 'success',
                  duration: 2000
                })
              }
              that.getVideoDetail();
            })
          }
        }
      })
    }
  }
})