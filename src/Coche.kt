/**
 * La clase coche hereda de las interfaces EncendidoApagado y Vehiculo
 * Los parámetros heredados son:
 * @param marca -> Cadena de caracteres que indica la marca del coche
 * @param modelo -> Cadena de caracteres que indica el modelo del coche
 * @param kmh -> Entero que representa la velcidad a la que va el coche
 * El parámetro propio es:
 * @param motorEncendido -> Booleano que indica el estado del coche
 */
class Coche(marca:String, modelo:String, kmh:Int,override var motorEncendido: Boolean = false) :EncendidoApagado, Vehiculo {
    init {
        require(marca.isNotBlank()) {"La marca no puede ser un campo vacío"}

        require(modelo.isNotBlank()) {"El modelo no puede ser un campo vacío"}

        require(kmh > 0) {"Este campo no puede ser menor que 0"}
    }
    val marca: String = marca.replaceFirstChar { it.uppercase() }
    val modelo:String = modelo.replaceFirstChar { it.uppercase() }
    override var kmh: Int = kmh

    override fun encender(): String {
        motorEncendido = true
        return "El motor se ha arrancado"
    }

    override fun apagar(): String {
        motorEncendido = false
        return "El motor se ha parado"
    }
    fun arrancado(): String{
        return if (motorEncendido){
            "Arrancado"
        } else{
            "Parado"
        }
    }

    override fun acelerar(vel: Int): String {
        if (motorEncendido){
            return super.acelerar(vel)
        }
        else{
            return "Para acelerar hay que tener el motor encendido"
        }
    }

    override fun frenar(vel: Int): String {
        if (motorEncendido){
            if (kmh - vel > 0){
                return super.frenar(vel)
            }
            else{
                return super.frenar(kmh)
            }
        }
        else{
            return "Por mucho que frenes no te vas a mover igualmente"
        }
    }

    override fun toString(): String {
        return "$marca $modelo con velocidad: $kmh Km/h que se encuentra ${arrancado()}"
    }
}