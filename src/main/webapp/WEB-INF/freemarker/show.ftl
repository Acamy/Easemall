<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
<div class="g-doc">
    <#if !(product??)>
    <div class="n-result">
        <h3>内容不存在！</h3>
    </div>
    <#else>
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${product.prodImgUrl}" alt=""></div>
        <div class="cnt">
            <h2>${product.prodTitle}</h2>
            <p class="summary">${product.prodSummary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${product.prodPrice}</span>
            </div>
            <div class="oprt f-cb">
                <#if user?? && user.userType==0>
                    <#if product.isBuy>
                    <span class="u-btn u-btn-primary z-dis">已购买</span>
                    <span class="buyprice">当时购买价格：¥${productBuyPrice}</span>
                    <#else>
                    <div class="num">购买数量
                        <span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">1</span><span id="addNum" class="moreNum"><a>+</a></span>
                    </div>
                    <div class="oprt f-cb">
                        <button class="u-btn u-btn-primary" data-buy="${product.prodId}">购买</button>
                    </div>
                    </#if>
                </#if>
                <#if user?? && user.userType==1>
                <a href="/edit?id=${product.prodId}" class="u-btn u-btn-primary">编 辑</a>
                </#if>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${product.prodDetail}
    </div>
    </#if>
</div>
<#include "./include/footer.ftl">
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageShow.js"></script>
</body>
</html>