function getCurrentDate() {
	var tenderDate = document.getElementById("tenderDate");
	var purchaseDate = document.getElementById("purchaseDate");
	var liftingDate = document.getElementById("liftingDate");
	var today = new Date();
	value = today.toISOString().substr(0, 10);
	tenderDate.value = value;
	purchaseDate.value = value;
	liftingDate.value = value;
}

function onLoadActivity() {
	getCurrentDate();
}