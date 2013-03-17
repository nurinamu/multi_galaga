var connect_layout = document.getElementById('connect_layout');
var connect_btn = document.getElementById('connectbtn');
var game_layout = document.getElementById('game_play');

$ = jQuery;
$('.game_play').hide();
$('.connect_layout').show();
connect_btn.onclick = onClick;

function onClick() {
	$('.game_play').show();
	$('.connect_layout').hide();
}
