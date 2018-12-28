package com.keguang.daily.json

import com.alibaba.fastjson.JSONObject

/**
  * @Author:keguang
  * @Date:2018 /7/30 17:20
  * @version v1.0.0
  */
object Map2JSON extends App {
  val jsonObj:JSONObject = new JSONObject()
  jsonObj.put("neme", "keguang")
  jsonObj.put("age", 23)
  println(jsonObj)
  println(jsonObj.getClass.getSimpleName)


}
