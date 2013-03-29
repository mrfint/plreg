/**
 * User: ykozlov
 * Date: 3/28/13
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
(function () {
    $(document).ready(function () {
        Array.prototype.random = function() {
            if (this.length) {
                return this[Math.floor(Math.random() * this.length)]
            } else {
                return;
            }
        };
        Math.randomInt = function(min, max) {
            return min + Math.floor(Math.random() * (max - min));
        };
        var data = [];
        for(var i= 0; i< 5 + (Math.random() * 15); i++) {
            data.push({
                name: ['King', "O'hara", 'McDonald', 'Stevens', 'Johnson', 'Adams', "Smith"].random() + ", " + ["Steven", "Jack", "Ann", "Mary", "Joahn"].random(),
                adate: "2013.04.20 " + Math.randomInt(7, 19) + ":" + ['00', '15', '30', '45'].random(),
                atype: 'Clinic visit ' + Math.randomInt(1, 100),
                resource: 'Room #' + Math.randomInt(1, 99),
                location: 'HMS ' + ['Donetsk', 'Lviv', 'Kiev', 'Rivne'].random() + ' hospital',
                mrn: Math.randomInt(10000, 100000),
                pcn: Math.randomInt(100, 1000).toString() + Math.randomInt(100, 1000).toString(),
                dob: '1985-10-04',
                phone: ['096', '067', '063', '068', '095'].random() + "-" + Math.randomInt(0, 10) + Math.randomInt(0, 10) + Math.randomInt(0, 10)  + "-" + Math.randomInt(0, 10) + Math.randomInt(0, 10) + "-" + Math.randomInt(0, 10) + Math.randomInt(0, 10)
            });
        }
        $( "#appointments .inner-list" ).html(
            $("#rowTemplate").render( data )
        );
    });
})();
