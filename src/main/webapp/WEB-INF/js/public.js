(function(w,d,u){
	var form = util.get('form');
	if(!form){
		return;
	}
    var $ = function(id){
        return document.getElementById(id);
    }

	var title = form['title'];
	var summary = form['summary'];
	var image = form['image'];
	var detail = form['detail'];
	var price = form['price'];
	var isSubmiting = false;
	var imgpre = util.get('imgpre');
	var loading = new Loading();
	var page = {
		init:function(){
			form.addEventListener('submit',function(e){
				if(!isSubmiting && this.check()){
					price.value = Number(price.value);
					isSubmiting = true;
					form.submit();
				}
			}.bind(this),false);
			[title,summary,image,detail,price].forEach(function(item){
				item.addEventListener('input',function(e){
					item.classList.remove('z-err');
				}.bind(this),false);
			}.bind(this));
			image.addEventListener('input',function(e){
				var value = image.value.trim();
				if(value != '' && /^(http|https):\/\//.test(value) && /\.(jpg|gif|png)$/.test(value)){
					imgpre.src = value;
                    $('imageUpload').value = '';
				}
			}.bind(this),false);
		},
		check:function(){
			var result = true;
			[
				[title,function(value){return value.length<2 || value.length>80}],
				[summary,function(value){return value.length<2 || value.length>140}],
				[image,function(value){return value == '' || !(/\.(jpg|gif|png)$/.test(value))}],
				[detail,function(value){return value.length<2 || value.length>1000}],
				[price,function(value){return value == '' || !Number(value)}]
			].forEach(function(item){
				var value = item[0].value.trim();
				if(item[1](value)){
					item[0].classList.add('z-err');
					result = false;
				}
				item[0].value = value;
			});
			return result;
		}
	};
	page.init();

    $('imageUpload').addEventListener('change', function(){
        //当没选中图片时，清除预览
        if(this.files.length === 0){
            $('imgpre').src = '';
            return;
        }

        //实例化一个FileReader
        var reader = new FileReader();

        reader.onload = function (e) {
            //当reader加载时，把图片的内容赋值给
            $('imgpre').src = e.target.result;
            image.value = $('imageUpload').value;
        };

        //读取选中的图片，并转换成dataURL格式
        reader.readAsDataURL(this.files[0]);
    }, false);

})(window,document);