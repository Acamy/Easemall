(function(w,d,u){
    var showContent = util.get('showContent');
    if(!showContent){
        return;
    }
    var loading = new Loading();
    var layer = new Layer();
    var page = {
        init:function(){
            showContent.addEventListener('click',function(e){
                var ele = e.target;
                var buy = ele && ele.dataset.buy;
                var total = $('allNum').innerHTML;
                if(buy){
                    layer.reset({
                        content:'确认加入购物车吗？',
                        onconfirm:function(){
                            layer.hide();
                            loading.show();
                            ajax({
                                data:{id:buy,num:total},
                                url:'/addCart',
                                success:function(result){
                                    loading.result('加入成功!');
                                },
                                error:function(message){
                                    loading.result(message||'加入失败!');
                                }
                            });
                        }.bind(this)
                    }).show();
                    return;
                }
            }.bind(this),false);
        }
    };
    page.init();

    var $ = function(id){
        return document.getElementById(id);
    }

    $('plusNum').onclick = function(e){
        e = window.event || e;
        o = e.srcElement || e.target;
        var num = $('allNum').textContent;
        if(num > 0){
            num --;
            $('allNum').innerHTML = num;
        }else{
            alert("您没有购买任何商品");
        }
    };

    $('addNum').onclick = function(e){
        e = window.event || e;
        o = e.srcElement || e.target;
        var num = $('allNum').textContent;
        num ++;
        $('allNum').innerHTML = num;
    };
})(window,document);