function changeImage(img,url,disp) {
	document.getElementById(img).src=url;
	document.getElementById("imgDisplay").src=disp;
}

function scrollNews(id) {
	var news = document.getElementById('news'+id).childNodes[1];
	var line1 = news.childNodes[6];
	var line2 = news.childNodes[8];
	var line3 = news.childNodes[4];
	var coinBasDroit = line3.childNodes[7].childNodes[0];
	var imgBas = line3.childNodes[5].childNodes[0];
	var fleche = document.getElementById('fleche'+id);
	
	if (line1.style.display == 'none'){
		line1.style.display = 'table-row';
		line2.style.display = 'table-row';
		coinBasDroit.src = 'images/field/right.gif';
		imgBas.src = 'images/field/empty.gif';
		fleche.src = './images/flecheDown.gif';
	} else {
		line1.style.display = 'none';
		line2.style.display = 'none';
		coinBasDroit.src = 'images/field/bottomright.gif';
		imgBas.src = 'images/field/bottom.gif';
		fleche.src = './images/flecheUp.gif';
	}
}

