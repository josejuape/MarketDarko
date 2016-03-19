document.getElementById('url_banner').addEventListener('change', archivo, false);
function archivo(evt) {
    var files = evt.target.files;
    // Obtenemos la imagen del campo "file".
    for (var i = 0, f; f = files[i]; i++) {
        //Solo admitimos imágenes.
        if (!f.type.match('image.*')) {
            continue;
        }
        var reader = new FileReader();
        reader.onload = (function(theFile) {
            return function(e) {
                // Insertamos la imagen
                document.getElementById("ctn_banner").innerHTML = ['<img class="banner_evento" src="', e.target.result, '" title="', escape(theFile.name), '"/>'].join('');
                document.getElementById("url_name_banner").value = escape(theFile.name);
            };
        })(f);
        reader.readAsDataURL(f);
    }
}

