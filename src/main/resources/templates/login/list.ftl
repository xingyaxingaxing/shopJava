<html>
<#include "../common/header.ftl">
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="post" action="/sell/seller/login">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label>
                    <input name="openId" type="text" class="form-control" value="${(sellerInfo.openId)!''}"  />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input  name="passWord" type="password" class="form-control" value="${(sellerInfo.passWord)!''}" />
                </div>

                    <button type="submit" class="btn btn-default">登录</button>

            </form>
        </div>
    </div>
</div>
</body>
</html>
