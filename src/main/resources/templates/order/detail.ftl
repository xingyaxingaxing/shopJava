<htm1>
    <head>
        <meta charset="UTF-8">
        <title>卖家订单详情</title>
        <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>

    <div id="wrapper" class="toggled">

        <#--边栏sidebar-->
        <#include "../common/nav.ftl">

        <div class="container">
            <div class="row clearfix">
                <div class="container">
                    <div class="col-md-4 column">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>
                                    订单Id
                                </th>
                                <th>
                                    订单总金额
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>${orderDTO.oderId}</td>
                                <td>${orderDTO.oderAmount}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <#--订单详情表部分-->
                    <div class="col-md-12 column">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>商品Id</th>
                                <th>商品名称</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>总额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTO.oderDetailList as orderDetail>
                                <tr>
                                    <td>${orderDetail.productId}</td>
                                    <td>${orderDetail.productName}</td>
                                    <td>${orderDetail.productPrice}</td>
                                    <td>${orderDetail.productQuantity}</td>
                                    <td>${orderDetail.productQuantity*orderDetail.productPrice}</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <#--操作-->
                    <div class="col-md-12 column">
                        <#if orderDTO.getOrderStatusEnum().message=="新订单">
                            <a href="/sell/seller/order/finish?oderId=${orderDTO.oderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
                            <a href="/sell/seller/order/cancle?oderId=${orderDTO.oderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
                        </#if>
                    </div>
                </div>
            </div>

        </div>
    </div>


 <#--  <div style="width:100%;border-style:solid;border-width:1pt;border-color:black;">

 <#--      <div style="width:25%;text-align:center;border-style:solid;border-width:1pt;border-color:black;display:inline;">
 <#--          <#--边栏sidebar-->
 <#--          <#include "../common/nav.ftl">
 <#--      </div>
 <#--  <div class="container">
 <#--      <div class="row clearfix">
 <#--          <div class="container">
 <#--          <div class="col-md-4 column">
 <#--              <table class="table">
 <#--                  <thead>
 <#--                  <tr>
 <#--                      <th>
 <#--                          订单Id
 <#--                      </th>
 <#--                      <th>
 <#--                          订单总金额
 <#--                      </th>
 <#--                  </tr>
 <#--                  </thead>
 <#--                  <tbody>
 <#--                  <tr>
 <#--                      <td>${orderDTO.oderId}</td>
 <#--                      <td>${orderDTO.oderAmount}</td>
 <#--                  </tr>
 <#--                  </tbody>
 <#--              </table>
 <#--          </div>

 <#--          <#--订单详情表部分-->
 <#--          <div class="col-md-12 column">
 <#--              <table class="table">
 <#--                  <thead>
 <#--                  <tr>
 <#--                      <th>商品Id</th>
 <#--                      <th>商品名称</th>
 <#--                      <th>价格</th>
 <#--                      <th>数量</th>
 <#--                      <th>总额</th>
 <#--                  </tr>
 <#--                  </thead>
 <#--                  <tbody>
 <#--                  <#list orderDTO.oderDetailList as orderDetail>
 <#--                      <tr>
 <#--                          <td>${orderDetail.productId}</td>
 <#--                          <td>${orderDetail.productName}</td>
 <#--                          <td>${orderDetail.productPrice}</td>
 <#--                          <td>${orderDetail.productQuantity}</td>
 <#--                          <td>${orderDetail.productQuantity*orderDetail.productPrice}</td>
 <#--                      </tr>
 <#--                  </#list>
 <#--                  </tbody>
 <#--              </table>
 <#--          </div>

 <#--          <#--操作-->
 <#--          <div class="col-md-12 column">
 <#--              <#if orderDTO.getOrderStatusEnum().message=="新订单">
 <#--                  <a href="/sell/seller/order/finish?oderId=${orderDTO.oderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
 <#--                  <a href="/sell/seller/order/cancle?oderId=${orderDTO.oderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
 <#--              </#if>
 <#--          </div>
 <#--      </div>
 <#--  </div>

 <#--  </div>
 <#--  </div>
    </body>
</htm1>