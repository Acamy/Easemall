<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
<#assign listType = RequestParameters['type']!'0'>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li <#if !(listType??) || listType != '1'>class="z-sel"</#if> ><a href="/">所有内容</a></li>
                <#if user?? && user.userType == 0><li <#if listType == '1'>class="z-sel"</#if> ><a href="/?type=1">未购买的内容</a></li></#if>
            </ul>
        </div>
    </div>
    <#if !productList?? || !productList?has_content>
    <div class="n-result">
        <h3>暂无内容！</h3>
    </div>
    <#else>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
        <#if user?? && user.userType == 0 && listType == '1'>
            <#list productList as x>
                <#if !x.isBuy>
                <li id="p-${x.prodId}">
                    <a href="/show?id=${x.prodId}" class="link">
                        <div class="img"><img src="${x.prodImgUrl}" alt="${x.prodTitle}"></div>
                        <h3>${x.prodTitle}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${x.prodPrice}</span></div>
                    </a>
                </li>
                </#if>
            </#list>
        <#else>
            <#list productList as x>
                <li id="p-${x.prodId}">
                    <a href="/show?id=${x.prodId}" class="link">
                        <div class="img"><img src="${x.prodImgUrl}" alt="${x.prodTitle}"></div>
                        <h3>${x.prodTitle}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${x.prodPrice}</span></div>
                        <#if user?? && user.userType==0 && x.isBuy><span class="had"><b>已购买</b></span></#if>
                        <#if user?? && user.userType==1 && x.isSell>
                            <span class="had">
                                <b>已出售</b>
                            </span>
                        </#if>
                    </a>
                    <#if user?? && user.userType==1>
                        <#if x.isSell>
                            <span class="del">已售${x.soldNum}件</span>
                        <#else>
                            <span class="u-btn u-btn-normal u-btn-xs del" data-del="${x.prodId}">删除</span>
                        </#if>
                    </#if>
                </li>
            </#list>
        </#if>
        </ul>
    </div>
    </#if>
</div>
<#include "./include/footer.ftl">
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageIndex.js"></script>
</body>
</html>