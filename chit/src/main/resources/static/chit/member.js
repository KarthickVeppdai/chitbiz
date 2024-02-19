$("#membertable button").on('click',function () {
    $.ajax({
          type: "GET",
          url: "/chit/home/getMember?id="+this.id,
          data: { id: this.id},
          contentType: "application/json",
          dataType: 'json',
          async: false,
          success: function(response) {
                      $('#name').val(response.name);
                      $('#id').val(response.id);
                      $('#mobile').val(response.membermobileno);
                      $('#gaurdian').val(response.guardian);
                      $('#gaurdianno').val(response.guardianmobileno);
                      $('#address').val(response.address);
                  }
        });
});