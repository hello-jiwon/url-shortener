var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        })
    },

    save : function () {
        var data = {
            originUrl: $("#url").val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/shorten',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data),
            success : function(res){
                alert(res.shortUrl);
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){
                alert("단축이 불가능합니다.");
            }
        })
    }
};

main.init();