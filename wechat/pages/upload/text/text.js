// pages/upload/text/text.js
const util = require("../../../utils/util")
const api = require("../../../config/api")

const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    activeID:1,
    topicName:"",
    contactType:["手机","微信","QQ"],
    content:"",
    name:"",
    username:"",
    userID:"",
    files: [],
    imageurl:[],
    contactNumber:"",
  },
  bindInputNumber:function(event){
    let value = event.detail.value;
    this.setData({
      contactNumber:value,
    })
  },
  bindInputName:function(event){
    let value = event.detail.value;
    this.setData({
      name:value,
    })
  },
  bindInputValue:function(event){
    let value = event.detail.value;
    this.setData({
      content:value,
    })
  },
  onLoad:function(options) {
    if(options.topicName){
      this.setData({
        topicName:options.topicName
      });
    }
    if(app.globalData.hasLogin){
      let userinfo=wx.getStorageSync('userInfo')
      let skey = wx.getStorageSync('skey')
      this.setData({
        username:userinfo.nickName,
        userID:skey
      })
    }
  },
  switchLabel:function(event){
    if(this.data.activeID==event.currentTarget.dataset.id){
      return false;
    }
    this.setData({
      activeID:event.currentTarget.dataset.id
    })
  },
  previewImage: function(e) {
    wx.previewImage({
      current: e.currentTarget.id, // 当前显示图片的http链接
      urls: this.data.files // 需要预览的图片http链接列表
    })
  },
  chooseImage: function(e) {
    if (this.data.files.length >5) {
      util.showErrorToast('只能上传五张图片')
      return false;
    }
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function(res) {
        that.setData({
          files: that.data.files.concat(res.tempFilePaths)
        });
        that.upload(res);
      }
    })
  },
  upload: function(res) {
    var that = this;
    wx.showLoading({
      title: '上传进度：0%',
      mask: true //是否显示透明蒙层，防止触摸穿透
    })
    const uploadTask = wx.uploadFile({
      url: api.UploadStorage,
      filePath: res.tempFilePaths[0],
      name: 'file',
      success: function(res) {
        wx.hideLoading()
        var _res = JSON.parse(res.data);
        if (_res.errno === 0) {
          var url = _res.data.url
          that.data.imageurl.push(url)
          that.setData({
            picUrls: that.data.imageurl
          })
        }
      },
      fail: function(e) {
        wx.hideLoading()
        wx.showModal({
          title: '错误',
          content: '上传失败',
          showCancel: false
        })
      },
    })
    uploadTask.onProgressUpdate((res) =>{
      wx.showLoading({
        title: '上传进度：'+res.progress+'%',
        mask: true //是否显示透明蒙层，防止触摸穿透
      })
      console.log("上传进度",res.progress)
      console.log("已经上传的数据长度，单位 Bytes:",res.totalBytesSent)
      console.log("预期需要上传的数据总长度，单位 Bytes:",res.totalBytesExpectedToSend)
    })
  },
  onPost:function(){
    let that = this;
    let contactType = this.data.contactType[this.data.activeID]
    if (!this.data.content) {
      util.showErrorToast('请填写评论')
      return false;
    }
    util.request(api.TextPost, {
      textName: that.data.name,
      textContent: that.data.content,
      textImageUrl: that.data.imageurl,
      textTopicName: that.data.topicName,
      textContactType: contactType,
      textContactNumber: that.data.contactNumber,
      userID: that.data.userID,
    }, 'POST').then(function(res) {
      if (res.errno === 0) {
        wx.showToast({
          title: '评论成功',
          complete: function() {
            wx.navigateBack();
          }
        })
      }
    });
  }
})