const util = require("../../../utils/util")
const api = require("../../../config/api")

const app = getApp()
Page({

  data: {
    videos:[],
    inputValue:"",
  },

  onLoad:function(){
    this.searchTap();
  },
  
  inputKeyword(e) {
    app.globalData.inputValue=e.detail.value
    if(e.detail.value){
      this.setData({
        inputValue:e.detail.value
      })
    }
  },
  searchTap:function(){
    var that = this;
    util.request(api.VideoSearch,{
      keyword:that.data.inputValue
    }).then(res=>{
      if(res.errno===0){
        that.setData({
          videos:res.data.videos
        })
      }
    })
  },  
  onPullDownRefresh() {
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.searchTap();
    wx.hideNavigationBarLoading() //完成停止加载
    wx.stopPullDownRefresh() //停止下拉刷新
  },
  handlewatchtap:function(e){
    wx.navigateTo({
      url: '../detail/detail?id='+JSON.stringify(e.currentTarget.dataset.idx),
    })
  },
})