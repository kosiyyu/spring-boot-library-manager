function search() {
  const input = document.getElementById('myInput');
  const filter = input.value.toUpperCase();
  row = document.querySelectorAll('[id=row]');
  const td = []
  for(var i = 0; i < row.length; i++){
	td[i] = row[i].getElementsByTagName("td")[0];
	const title = td[i].getElementsByTagName("a")[0];
	let txtValue = "";
	txtValue = title.textContent || title.innerText;
	if (txtValue.toUpperCase().indexOf(filter) > -1) {
		row[i].style.display = "";
		} else 
		row[i].style.display = "none";
	}
}