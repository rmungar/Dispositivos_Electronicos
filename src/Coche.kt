/**
 * La clase coche hereda de las interfaces EncendidoApagado y Vehiculo
 * Las propiedades heredadas son:
 * @property marca -> Cadena de caracteres que indica la marca del coche
 * @property modelo -> Cadena de caracteres que indica el modelo del coche
 * @property kmh -> Entero que representa la velcidad a la que va el coche
 * La propiedad propia es:
 * @property motorEncendido -> Booleano que indica el estado del coche
 */
class Coche(marca:String, modelo:String, override var kmh: Int,override var motorEncendido: Boolean = false) :EncendidoApagado, Vehiculo {
    init {
        require(marca.isNotBlank()) {"La marca no puede ser un campo vacío"}

        require(modelo.isNotBlank()) {"El modelo no puede ser un campo vacío"}

        require(kmh > 0) {"Este campo no puede ser menor que 0"}
    }
    private val marca: String = marca.replaceFirstChar { it.uppercase() }
    private val modelo:String = modelo.replaceFirstChar { it.uppercase() }


    /**
     * Cambia el valor del motorEncendido del objeto y retorna un String
     * @return String
     */
    override fun encender(): String {
        motorEncendido = true
        return "El motor se ha arrancado"
    }
    /**
     * Cambia el valor del motorEncendido del objeto y retorna un String
     * @return String
     */
    override fun apagar(): String {
        motorEncendido = false
        return "El motor se ha parado"
    }
    /**
     * Comprueba el valor de motorEncendido y retorna un String en función de dicho valor
     * @return String
     */
    private fun arrancado(): String{
        return if (motorEncendido){
            "Arrancado"
        } else{
            "Parado"
        }
    }

    /**
     * La función acelerar toma un valor, comprueba el estado del coche y actua en función de esta
     * @param vel -> Entero que representa una velocidad
     * @return -> String que nos indica la velocidad del vehiculo
     */
    override fun acelerar(vel: Int): String {
        return if (motorEncendido){
            super.acelerar(vel)
        } else{
            "Para acelerar hay que tener el motor encendido"
        }
    }

    /**
     * La función acelerar toma un valor, comprueba el estado del coche y actua en función de esta
     * @param vel -> Entero que representa una velocidad
     * @return -> String que nos indica la velocidad del vehiculo
     */
    override fun frenar(vel: Int): String {
        return if (motorEncendido){
            if (kmh - vel > 0){
                super.frenar(vel)
            } else{
                super.frenar(kmh)
            }
        } else{
            "Por mucho que frenes no te vas a mover igualmente"
        }
    }

    override fun toString(): String {
        return "$marca $modelo con velocidad: $kmh Km/h que se encuentra ${arrancado()}"
    }
}