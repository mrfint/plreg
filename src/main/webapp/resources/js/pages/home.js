/**
 * User: ykozlov
 * Date: 3/28/13
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
(function () {
    $(document).ready(function () {
        Array.prototype.random = function () {
            if (this.length) {
                return this[Math.floor(Math.random() * this.length)]
            } else {
                return;
            }
        };
        Math.randomInt = function (min, max) {
            return min + Math.floor(Math.random() * (max - min));
        };
        var appointments = new AppointmentsCollection();
        appointments.fetch({
            success: function () {
                console.log("Collection");
                console.log(appointments.toJSON());
                render(appointments.toJSON());
            }
        });
        $(".logout").on("click", function () {
            window.location.replace("/loggedout");
        });
        $(".home").on("click", function () {
            window.location.replace("/home");
        });
    });
    function render(appointments) {
        $("#appointments .inner-list").html(
            $("#rowTemplate").render(appointments)
        );
    }
})();
