### 高德地图API使用调研

#### 1. 地理编码

##### 1.1 西土城路

请求参数：

![image-20210804151557120](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804151557120.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"1",
    "geocodes" :[
        {
        "formatted_address" :"北京市海淀区西土城路",
        "country" :"中国",
        "province" :"北京市",
        "citycode" :"010",
        "city" :"北京市",
        "district" :"海淀区",
        "township" :[ ],
        "neighborhood" :{
            "name" :[ ],
            "type" :[ ]
        },
        "building" :{
            "name" :[ ],
        "type" :[ ]
        },
        "adcode" :"110108",
        "street" :[ ],
        "number" :[ ],
        "location" :"116.354606,39.967764",
        "level" :"道路"
        }
    ]
}
```

**分析：**只输入街道信息，比如西土城路，高德地图地理编码API会返回该街道对应的省，市、区等信息，同时地理编码信息列表` 地理编码信息列表`中还有行政区划编码`adcode`和经纬度地址`location`的信息。

##### 1.2 西土城路10号

请求参数：

![image-20210804152844016](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804152844016.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"1",
    "geocodes" :[
        {
            "formatted_address" :"北京市海淀区西土城路|10号",
            "country" :"中国",
            "province" :"北京市",
            "citycode" :"010",
            "city" :"北京市",
            "district" : "海淀区",
            "township" :[ ],
            "neighborhood" :{
                "name" :[ ],
                "type" :[ ]
            },
            "building" : {
                "name" :[ ],
                "type" :[ ]
             },
            "adcode" :"110108",
            "street" :"西土城路",
            "number" : "10号",
            "location" :"116.358077,39.959628",
            "level" :"门牌号"
            }
    ]
}
```

**分析：**只输入道路+门牌号信息，比如西土城路10号，高德地图地理编码API会返回该地址对应的省，市、区等信息，同时地理编码信息列表` 地理编码信息列表`中还有行政区划编码`adcode`，和经纬度地址`location`的信息，并解析出街道`street`和门牌号`number`等信息。

##### 1.3 北京市海淀区西土城路10号

请求参数：

![image-20210804153409567](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804153409567.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"1",
    "geocodes" :[
        {
            "formatted_address" :"北京市海淀区西土城路|10号",
            "country" :"中国",
            "province" :"北京市",
            "citycode" :"010",
            "city" :"北京市",
            "district" : "海淀区",
            "township" :[ ],
            "neighborhood" :{
                "name" :[ ],
                "type" :[ ]
            },
            "building" : {
                "name" :[ ],
                "type" :[ ]
             },
            "adcode" :"110108",
            "street" :"西土城路",
            "number" : "10号",
            "location" :"116.358077,39.959628",
            "level" :"门牌号"
            }
    ]
}
```

**分析：**完整地址的返回结果与只输入街道+门牌号的结果是一样的。

##### 1.4 西土城路10号北京邮电大学主楼

请求参数：

![image-20210804154008729](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804154008729.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"1",
    "geocodes" :[
        {
            "formatted_address" :"北京市海淀区北京邮电大学主楼",
            "country" :"中国",
            "province" :"北京市",
            "citycode" :"010",
            "city" :"北京市",
            "district" : "海淀区",
            "township" :[ ],
            "neighborhood" :{
                "name" :[ ],
                "type" :[ ]
            },
            "building" : {
                "name" :[ ],
                "type" :[ ]
             },
            "adcode" :"110108",
            "street" :[ ],
            "number" : [ ],
            "location" :"116.358342,39.961179",
            "level" :"兴趣点"
            }
    ]
}
```

**分析：**当输入街道+门牌号+建筑名称时，如果该地址属于高德地图的POI(兴趣点)列表，则地理编码API会将相应的POI信息返回来，同样包括该地址对应的省，市、区等信息，行政区划编码`adcode`，和经纬度地址`location`的信息，同时该经纬度地址定位的就是对应POI的准确地址。

##### 1.5 西土城路10号北京邮电大学家属区9号楼

请求参数：

![image-20210804155121809](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804155121809.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"1",
    "geocodes" :[
        {
            "formatted_address" :"北京市海淀区北京邮电大学家属区|9号楼",
            "country" :"中国",
            "province" :"北京市",
            "citycode" :"010",
            "city" :"北京市",
            "district" : "海淀区",
            "township" :[ ],
            "neighborhood" :{
                "name" :[ ],
                "type" :[ ]
            },
            "building" : {
                "name" :[ ],
                "type" :[ ]
             },
            "adcode" :"110108",
            "street" :[ ],
            "number" : [ ],
            "location" :"116.356471,39.958423",
            "level" :"门牌号"
            }
    ]
}
```

**分析：**当输入街道+门牌号+小区建筑时，高德地图地理编码API会返回该地址对应的省，市、区等信息，同时地理编码信息列表` geocodes`中还有行政区划编码`adcode`和经纬度地址`location`的信息，并且该地址的`level`为门牌号，但没有对应的街道`street`和门牌号`number`信息，错误的将详细地址`北京邮电大学家属区9号楼`中的`9号楼`识别成了门牌号信息，但在解析街道信息时并没有解析出正确的街道信息。并且通过经纬度坐标反查，定位存在一定偏差，但偏差不大，还在北京邮电大学家属区内，只是与地图上显示的家属楼名称不对应，如下图所示。并且如果继续输入更加详细的单元号楼层门牌号信息，比如9号楼1单元，发现返回结果只能精确到楼宇，与当前返回结果相同。

![image-20210804160209446](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804160209446.png)

##### 1.6 总结

利用高德地图地理编码API，只输入街道/街道+门牌号，是可以获得该地址的省，市，区的信息，并且还有行政区划编码，经纬度地址等信息，对于地址补全有使用价值。高德地图地理编码API返回的地址信息最小单位是楼宇，可以定位到小区集群中的楼宇信息，但地址编码有一定的误差，也足够准确了。

#### 2. 逆地理编码

请求参数：

![image-20210804194725940](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804194725940.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "regeocode" :{
        "formatted_address" :"北京市海淀区北太平庄街道西土城路10号院北京邮电大学海淀校区",
        "addressComponent" :{
            "country" :"中国",
            "province" :"北京市",
            "city" :[ ],
            "citycode" :"010",
            "district" :"海淀区",
            "adcode" :"110108",
            "township" :"北太平庄街道",
            "towncode" :"110108008000",
            "neighborhood" :{
                "name" :[ ],
                "type" :[ ]
                },
            "building" :{
                "name" :[ ],
                "type" :[ ]
                },
            "streetNumber" :{
                "street" :"西土城路",
                "number" :"10号院",
                "location" :"116.358185,39.958609",
                "direction" :"南",
                "distance" :"113.705"
                },
            "businessAreas" :[
                {
                    "location" :"116.346661,39.942856",
                    "name" :"西直门",
                    "id" :"110102"
                },
                {
                    "location" :"116.364058,39.957147",
                    "name" :"小西天",
                    "id" :"110108"
                },
                {
                    "location" :"116.338730,39.955976",
                    "name" :"北下关",
                    "id" :"110108"
                }
            ]
},
        "pois" :[ ],
        "roads" :[
            {
                "id" :"010J50F0010192541",
                "name" :"学院南路",
                "direction" :"北",
                "distance" :"172.577",
                "location" :"116.358,39.9581"
            },
            {
                "id" :"010J50F0010195460",
                "name" :"文慧园西路",
                "direction" :"北",
                "distance" :"172.578",
                "location" :"116.358,39.9581"
            },
            {
                "id" :"010J50F001019378",
                "name" :"西土城路辅路",
                "direction" :"东",
                "distance" :"246.535",
                "location" :"116.355,39.9595"
            },
        ],
        "roadinters" :[
            {
                "direction" :"北",
                "distance" :"186.418",
                "location" :"116.358091,39.957952",
                "first_id" :"010J50F0010192541",
                "first_name" :"学院南路",
                "second_id" :"010J50F0010195460",
                "second_name" :"文慧园西路"
            }
        ],
        "aois" :[
            {
                "id" :"B000A7CPWG",
                "name" :"北京邮电大学海淀校区",
                "adcode" :"110108",
                "location" :"116.358104,39.961554",
                "area" :"367550.160026",
                "distance" :"0",
                "type" :"141201"
            }
        ]
    }
}
```

**分析：**逆地理编码API主要是根据输入的经纬度地址`location`得到逆地理编码列表`regeocodes`，包括**结构化地址信息**(省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码)`formatted_address`,地址元素列表`addressComponent`,道路信息列表`roads`,道路交叉口列表`roadinters`, poi信息列表`pois`,aoi信息列表`aois`。其中地址元素列表`addressComponent`解析出了国家，省，市，区，街道，门牌号等信息。请求参数中除了`location`必需外，其他可选参数主要影响的是poi信息列表`pois`，主要受两个参数影响：`poitype`返回附近POI类型，`radius`搜索半径。以下介绍一下这两个参数对于`pois`的影响。

##### 2.1 附近POI类型

附近POI类型的选择需要参考高德地图的[POI分类码表](https://lbs.amap.com/api/webservice/download)，如果输入的不是分类码表中的类别或类别编号，那么默认附近POI类型的选择为商务住宅。POI分类码表中，将POI分为大类、中类、小类，小类属于某个中类，中类属于某个大类，类别编码有6位，前两位表示大类，中间两位表示中类，最后两位表示小类。其中大类包括以下几个方面：

![image-20210804195844620](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804195844620.png)![image-20210804200011154](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804200011154.png)![image-20210804200054088](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804200054088.png)

当然大类里还有一些中类和小类，只有在请求参数中输入正确的类别名称或编号，才能查询到符合该POI类型的POI信息。在这里以北邮的经纬度为标准，选取几个不同的附近POI类别展示一下。

**分析：**请求参数`poitype`返回附近POI类型，主要是通过`pois`的`type`标签进行筛选，将符合返回附近POI类型的POI列表返回。

- 地名地址信息

  请求参数：

  ![image-20210804201438743](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804201438743.png)

  返回结果：

  ```json
  {
      "status" :"1",
      "info" :"OK",
      "infocode" :"10000",
      "regeocode" :{
          "formatted_address" :"北京市海淀区北太平庄街道西土城路10号院北京邮电大学海淀校区",
          "addressComponent" :{...},
          "pois" :[
              {
              "id" :"B0FFI5ZSS3",
              "name" :"德胜门外大街34号楼",
              "type" :"地名地址信息;地名地址信息;地名地址信息",
              "tel" :[ ],
              "direction" :"东",
              "distance" :"1885.95",
              "location" :"116.379875,39.956718",
              "address" :"西城区",
              "poiweight" :"0.202281",
              "businessarea" :"西直门"
              },
              {...},
              {...},
          ],
          "roads" :[...],
          "roadinters" :[...],
          "aois" :[...]
      }
  }
  ```

- 商务住宅

  请求参数：

  ![image-20210804202014541](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804202014541.png)

  返回结果：

  ```json
  {
      "status" :"1",
      "info" :"OK",
      "infocode" :"10000",
      "regeocode" :{
          "formatted_address" :"北京市海淀区北太平庄街道西土城路10号院北京邮电大学海淀校区",
          "addressComponent" :{...},
          "pois" :[
              {
              "id" :"B000A7CPWG",
              "name" :"北京邮电大学海淀校区",
              "type" :"科教文化服务;学校;高等院校",
              "tel" :"010-62282023;010-62282615",
              "direction" :"北",
              "distance" :"214.165",
              "location" :"116.358104,39.961554",
              "address" :"西土城路10号",
              "poiweight" :"0.685828",
              "businessarea" :"西直门"
              },
              {...},
              {...},
              {...},
              {...},
              {...},
              {...},
              {...},
              {...},
              {...},
              {...},
              {...},
              {...},
          ],
          "roads" :[...],
          "roadinters" :[...],
          "aois" :[...]
      }
  }
  ```

##### 2.2 搜索半径

**分析：**搜索半径radius，控制查询坐标点多少半径范围内的POI，主要影响`pois`列表元素个数，取值范围：0~3000,单位：米。主要通过`pois`的`distance`属性进行筛选。下面以地名地址信息为返回附近POI类型为例，选取1000,2000,3000三种搜索半径来对比一下返回的`pois`的个数。一般最多一次返回30个POI信息。

- 半径为1000：`pois`列表为空

  ![image-20210804203205928](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804203205928.png)

- 半径为2000：`pois`列表元素个数为1

  ![image-20210804203259062](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804203259062.png)

- 半径为3000：`pois`列表元素个数为3

  ![image-20210804203336405](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804203336405.png)

#### 3. 搜索POI

在逆地理编码的返回结果中已经根据坐标信息返回了符合要求的POI信息，而搜索POI信息主要有4种适用场景：

- 关键字搜索：通过用POI的关键字进行条件搜索，例如：肯德基、朝阳公园等；同时支持设置POI类型搜索，例如：银行
- 周边搜索：在用户传入经纬度坐标点附近，在设定的范围内，按照关键字或POI类型搜索；
- 多边形搜索：在多边形区域内进行搜索
- ID查询：通过POI ID，查询某个POI详情，建议可同输入提示API配合使用

其中周边搜索和逆地理编码API的效果基本是一样的，周边搜索只是多了一个关键字的请求参数。

##### 3.1 关键字搜索

请求参数：

![image-20210804204053206](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804204053206.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"58",
    "suggestion" :
    {
        "keywords" :[ ],
        "cities" :[ ]
    },
    "pois" :[
        {
            "id" :"B000A7CPWG",
            "parent" :[ ],
            "childtype" :[ ],
            "name" :"北京邮电大学海淀校区",
            "tag" :[ ],
            "type" :"科教文化服务;学校;高等院校",
            "typecode" :"141201",
            "biz_type" :[ ],
            "address" :"西土城路10号",
            "location" :"116.358104,39.961554",
            "tel" :"010-62282023;010-62282615",
            "postcode" :"100876",
            "website" :"www.bupt.edu.cn",
            "email" :[ ],
            "pcode" :"110000",
            "pname" :"北京市",
            "citycode" :"010",
            "cityname" :"北京市",
            "adcode" :"110108",
            "adname" :"海淀区",
            "importance" :[ ],
            "shopid" :[ ],
            "shopinfo" :"0",
            "poiweight" :[ ],
            "gridcode" :"5916725811",
            "distance" :[ ],
            "navi_poiid" :"J50F001019_31165",
            "entr_location" :"116.355209,39.961124",
            "business_area" :"小西天",
            "exit_location" :[ ],
            "match" :"0",
            "recommend" :"0",
            "timestamp" :"2021-08-04 10:13:19",
            "alias" :"北邮",
            "indoor_map" :"0",
            "indoor_data" :{ … },
            "groupbuy_num" :"0",
            "discount_num" :"0",
            "biz_ext" :{ … },
            "event" :[ ],
            "children" :[ … ],
            "photos" :[ … ]
        },
        {...},
        {...},
        {...},
        {...},
        ...
    ]
}
```

**分析：**可以看到返回结果中包含58条与“北京邮电大学”相关的POI信息，且返回的`pois`列表元素包括市，区，街道，别名等信息，还包括与之相关的子POI信息。

##### 3.2 周边搜索

请求参数：

![image-20210804205144238](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804205144238.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"37",
    "suggestion" :
    {
        "keywords" :[ ],
        "cities" :[ ]
    },
    "pois" :[
        {
            "id" :"B0FFH14ECK",
            "parent" :"B000A7CPWG",
            "childtype" :"309",
            "name" :"北京邮电大学学生二公寓",
            "tag" :[ ],
            "type" :"商务住宅;住宅区;宿舍",
            "typecode" :"120303",
            "biz_type" :[ ],
            "address" :"西土城路10号北京邮电大学北京邮电大学学生公寓2号楼北太平庄街道",
            "location" :"116.356763,39.962426",
            "tel" :[ ],
            "postcode" :[ ],
            "website" :[ ],
            "email" :[ ],
            "pcode" :"110000",
            "pname" :"北京市",
            "citycode" :"010",
            "cityname" :"北京市",
            "adcode" :"110108",
            "adname" :"海淀区",
            "importance" :[ ],
            "shopid" :[ ],
            "shopinfo" :"0",
            "poiweight" :[ ],
            "gridcode" :"5916725811",
            "distance" :"150",
            "navi_poiid" :"J50F001019_324631;585185",
            "entr_location" :[ ],
            "business_area" :"小西天",
            "exit_location" :[ ],
            "match" :"0",
            "recommend" :"0",
            "timestamp" :"2021-07-16 16:55:57",
            "alias" :[ ],
            "indoor_map" :"0",
            "indoor_data" :{ … },
            "groupbuy_num" :"0",
            "discount_num" :"0",
            "biz_ext" :{ … },
            "event" :[ ],
            "children" :[ ],
            "photos" :[ … ]
        },
        {...},
        {...},
        {...},
        {...},
        ...
    ]
}
```

**分析：**可以看到中心点为北京邮电大学海淀校区经纬度坐标，关键字为宿舍，POI类型为住宅区，查询半径为1000米的返回结果中包含37条与其相关的POI信息，且有些POI之间是父子关系，比如这次返回的学二公寓POI与北京邮电大学海淀校区POI，通过`parent`来关联。

##### 3.3 多边形搜索

请求参数：

![image-20210804210048861](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804210048861.png)

**注意：**polygon传入的应该是经纬度坐标对(矩形时可传入左上右下两顶点坐标对；其他情况首尾坐标对需相同。)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"3",
    "suggestion" :
    {
        "keywords" :[ ],
        "cities" :[ ]
    },
    "pois" :[
        {
            "id" :"B000A7BM4H",
            "parent" :"B0FFF5UV26",
            "childtype" :"202",
            "name" :"肯德基(花家地店)(装修中)",
            "tag" :"原味吮指鸡,波纹薯条,吮指原味鸡T,全家桶套餐,香辣鸡腿堡S豆泥餐T,藜麦蛋挞拿铁沙啦餐T,葡式蛋挞T,香辣鸡腿堡STN,金沙咸蛋黄香辣鸡翅,老北京鸡肉卷,香草风味冰拿铁,奥堡辣翅荟蔬汤餐,新奥尔良烤翅,葡式蛋挞经典装,比利时冰淇淋杯,香醇奶茶T,现烤法式可颂配美式,塔可青年单人餐,超级塔可,十三鲜小龙虾烤鸡堡T,香脆薯饼T,醇香土豆泥T,缤纷小食欢享餐,培根饭团热浆春卷餐,猪柳蛋帕尼S拿铁薯",
            "type" :"餐饮服务;快餐厅;肯德基",
            "typecode" :"050301",
            "biz_type" :"diner",
            "address" :"花家地小区1号商业楼",
            "location" :"116.469316,39.985542",
            "tel" :"4009200715",
            "postcode" :[ ],
            "website" :[ ],
            "email" :[ ],
            "pcode" :"110000",
            "pname" :"北京市",
            "citycode" :"010",
            "cityname" :"北京市",
            "adcode" :"110105",
            "adname" :"朝阳区",
            "importance" :[ ],
            "shopid" :[ ],
            "shopinfo" :"0",
            "poiweight" :[ ],
            "gridcode" :"5916738701",
            "distance" :[ ],
            "navi_poiid" :"J50F001020_425283",
            "entr_location" :"116.469414,39.985729",
            "business_area" :"望京",
            "exit_location" :"[ ]",
            "match" :"0",
            "recommend" :"0",
            "timestamp" :"2021-08-04 11:27:15",
            "alias" :[ ],
            "indoor_map" :"0",
            "indoor_data" :{ … },
            "groupbuy_num" :"0",
            "discount_num" :"0",
            "biz_ext" :{ … },
            "event" :[ ],
            "children" :[ ],
            "photos" :[ … ]
        },
        {...},
        {...},
    ]
}
```

**分析：**这种POI搜索要求知道区域边界的信息，在已知区域边界查找某些POI时还是非常有用的。

##### 3.4 ID查询

请求参数：

![image-20210804212155534](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804212155534.png)

返回结果：

```json
{
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"1",
    "pois" :[
        {
            "id" :"B000A7CPWG",
            "parent" :[ ],
            "childtype" :[ ],
            "name" :"北京邮电大学海淀校区",
            "tag" :[ ],
            "type" :"科教文化服务;学校;高等院校",
            "typecode" :"141201",
            "biz_type" :[ ],
            "address" :"西土城路10号",
            "location" :"116.358104,39.961554",
            "tel" :"010-62282023;010-62282615",
            "postcode" :"100876",
            "website" :"www.bupt.edu.cn",
            "email" :[ ],
            "pcode" :"110000",
            "pname" :"北京市",
            "citycode" :"010",
            "cityname" :"北京市",
            "adcode" :"110108",
            "adname" :"海淀区",
            "importance" :[ ],
            "shopid" :[ ],
            "shopinfo" :"0",
            "poiweight" :[ ],
            "gridcode" :"5916725811",
            "distance" :[ ],
            "navi_poiid" :"J50F001019_31165",
            "entr_location" :"116.355209,39.961124",
            "business_area" :"小西天",
            "exit_location" :[ ],
            "match" :"0",
            "recommend" :"0",
            "timestamp" :"2021-08-04 10:13:19",
            "alias" :"北邮",
            "indoor_map" :"0",
            "indoor_data" :{ … },
            "groupbuy_num" :"0",
            "discount_num" :"0",
            "biz_ext" :{ … },
            "event" :[ ],
            "children" :[ … ],
            "photos" :[ … ]
        }
    ]
}
```

**分析：**这种搜索方式价值不大，每个图商的兴趣点ID可能也不一样，用户不可能去记兴趣点ID，直接根据兴趣点ID查询不现实。

##### 3.5 AOI边界查询

该服务属于高德开放平台高阶服务，正式使用前需要通过工单等形式联系高德地图官方开通权限。

#### 4. 输入提示

提供根据用户输入的关键词查询返回建议列表。

请求参数：

![image-20210804212736624](C:\Users\10604\AppData\Roaming\Typora\typora-user-images\image-20210804212736624.png)

返回结果：

```json
{
    "tips" :
        [
            {
                "id" :[ ],
                "name" :"肯德基",
                "district" :[ ],
                "adcode" :[ ],
                "location" :[ ],
                "address" :[ ],
                "typecode" :[ ],
                "city" :[ ]
            },
            {
                "id" :"B0FFKEPXS2",
                "name" :"肯德基(望京西店)",
                "district" :"北京市朝阳区",
                "adcode" :"110105",
                "location" :"116.474074,39.997774",
                "address" :"望京西园4区410号综合楼1层",
                "typecode" :"050301",
                "city" :[ ]
            },
            { … },
            { … },
            { … },
            { … },
            { … },
            { … },
            { … },
            { … }
    ],
    "status" :"1",
    "info" :"OK",
    "infocode" :"10000",
    "count" :"10"
}
```

**分析：**输入提示和搜索POI比较类似，只是返回的`tips`列表中除了POI类型数据，可能还有公交站点数据类型、公交线路数据类型，这个可以通过请求参数中的`datatype`来控制。