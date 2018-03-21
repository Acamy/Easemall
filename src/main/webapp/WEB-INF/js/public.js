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
				}
			}.bind(this),false);
		},
		check:function(){
			var result = true;
			[
				[title,function(value){return value.length<2 || value.length>80}],
				[summary,function(value){return value.length<2 || value.length>140}],
				[image,function(value){return value == '' || !(/^(http|https):\/\//.test(value) && /\.(jpg|gif|png)$/.test(value))}],
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

    $('imageUpload').onchange = function() {
        var imgFile = this.files[0];
        //获取input:type='file'选中文件的内容
        var fileName= $("imageUpload").value;

        if (fileName == null || fileName == "") {
            alert("请选择上传文件");
            document.getElementById('imgpre').src = '';
        } else {
            var fr = new FileReader();
            fr.onload = function() {
                //$("img_id").value = fr.result;
                $('imgpre').src = fr.result;
            };
            fr.readAsDataURL(imgFile);

            var formData = new FormData();
            //此处将所要传递的数据append到formData中
            formData.append("fileinfo", imgFile);


            ajax({
                url: "/uploadFile",
                type: "POST",
                data: formData,
                processData: false,       //必不可缺
                contentType: false,       //必不可缺
                success: function (e) {
                    alert("文件上传成功");
                    //$("#file").val() == "";
                }
            })

        }
    };

})(window,document);