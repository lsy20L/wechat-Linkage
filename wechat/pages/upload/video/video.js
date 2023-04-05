const util = require("../../../utils/util")
const api = require("../../../config/api")

const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    videoName:"",
    videoIntro:"",
    videoUrl:"",
    imageUrl:"",
    duration:"",
    clickFlag:true,
  },
  chooseVideo: function () {
    this.setData({clickFlag: false})
    let that = this
    wx.chooseMedia({
      count:1,
      mediaType:['video'],
      sourceType:['album'],
      
      success:function(res){
        that.setData({
          duration:res.tempFiles[0].duration
        })
        that.upload(res);
      }
    })
  },
  chooseImage:function(){
    let that = this
    wx.chooseMedia({
      count:1,
      mediaType:['image'],
      sourceType:['album'],
      sizeType:['compressed'],
      success:function(res){
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
      filePath: res.tempFiles[0].tempFilePath,
      name: 'file',
      success: function(res) {
        wx.hideLoading()
        var _res = JSON.parse(res.data);
        if (_res.errno === 0) {
          let type = _res.data.type.split("/")[0];
          if(type=="video"){
            that.setData({
            videoUrl:  _res.data.url
          })
        }else if(type=="image"){
          that.setData({
            imageUrl:  _res.data.url
          })
        }
        }
      },
      fail: function(e) {
        console.log(e)
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
  inputName:function(event){
    let value = event.detail.value;
    this.setData({
      videoName:value,
    })
  },
  inputIntro:function(event){
    let value = event.detail.value;
    this.setData({
      videoIntro:value,
    })
  },
  onPost:function(){
    let that = this;
    if (!this.data.videoUrl) {
      util.showErrorToast('请上传视频')
      return false;
    }
    if (!this.data.imageUrl) {
      util.showErrorToast('请上传封面')
      return false;
    }
    if (!this.data.videoName) { 
      util.showErrorToast('请填写标题')
      return false;
    }
    if (!this.data.videoIntro) {
      util.showErrorToast('请填写简介')
      return false;
    }
    util.request(api.VideoPost, {
      videoName: that.data.videoName,
      videoUrl: that.data.videoUrl,
      videoImageUrl: that.data.imageUrl,
      videoIntroduction: that.data.videoIntro,
      userID: wx.getStorageSync('skey'),
      videoDuration: that.data.duration,
    }, 'POST').then(function(res) {
      if (res.errno === 0) {
        wx.showToast({
          title: '发布成功',
          complete: function() {
            wx.navigateBack();
          }
        })
      }
    });
  }
  
})