$(function() {
	// solving the active menu probblem
	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Al Products':
		$('#listproducts').addClass('active');
		break;	
	default:
		$('#listproducts').addClass('active');
	    $('#a_'+menu).addClass('active');
	}
});