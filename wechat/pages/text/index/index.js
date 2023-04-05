const util = require("../../../utils/util")
const api = require("../../../config/api")

const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    topics:[],
    texts:[]
  },
  getData:function(){
    let that = this
    util.request(api.TextIndex).then(function(res){
      if(res.errno===0){
        that.setData({
          topics:res.data.topics,
          texts:res.data.texts
        })
      }
    })
  },
  onPullDownRefresh() {
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.getData();
    wx.hideNavigationBarLoading() //完成停止加载
    wx.stopPullDownRefresh() //停止下拉刷新
  },
  onLoad:function(){
    this.getData();
  }
})