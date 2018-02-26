<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">



<div class="g-doc" id="cart">
    <div class="m-tab m-tab-fw m-tab-simple f-cb" >
        <h2>已添加到购物车的内容</h2>
    </div>

    <table id="newTable" class="m-table m-table-row n-table g-b3">
        <tr><th>内容名称</th><th>数量</th><th>价格</th></tr>
        <#list cartList as cart>
            <tr><td>${cart.prodTitle}</td><td><span class="lessNum">-</span><span class="totalNum" id="allNum">${cart.prodNum}</span>
                <span id="thisId">${cart.prodId}</span><span class="moreNum">+</span></td><td>${cart.prodPrice}</td></tr>
        </#list>
    </table>

    <div id="act-btn">
        <button class="u-btn u-btn-primary" id="back">退出</button>

        <#if cartList?? && cartList?has_content>
            <button class="u-btn u-btn-primary" id="Account">购买</button></div>
        </#if>
    </div>

<#include "./include/footer.ftl">
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/cart.js"></script>

</body>
</html>