/**
 * La clase coche hereda de las interfaces EncendidoApagado y Vehiculo
 * Las propiedades heredadas son:
 * @property marca -> Cadena de caracteres que indica la marca del teléfono
 * @property modelo -> Cadena de caracteres que indica el modelo del teléfono
 * Las propiedades propias son:
 * @property estado -> String que indica el estado del teléfono
 * @property reiniciado -> Booleano que indica si el telefono ha sido reiniciado o no
 */
class Telefono(private val marca: String, private val modelo: String, private var estado:String = "Apagado") : EncendidoApagado, DispositivoElectronico {

    private var reiniciado: Boolean = false
    init {
        require(marca.isNotBlank()) {"La marca no puede ser un campo vacío"}
        marca.replaceFirstChar { it.uppercase() }
        require(modelo.isNotBlank()) {"El modelo no puede ser un campo vacío"}
        modelo.replaceFirstChar { it.uppercase() }
    }
    /**
     * Cambia el valor del estado del objeto y retorna un String
     * @return String
     */
    override fun encender(): String {
        estado = "Encendido"
        return super.encender()
    }
    /**
     * Cambia el valor del estado del objeto y retorna un String
     * @return String
     */
    override fun apagar(): String {
        estado = "Apagado"
        return super.apagar()
    }
    /**
     * Cambia el valor del estado del objeto y retorna un String
     * @return String
     */
    override fun reiniciar(): String {
        reiniciado = true
        return super.reiniciar()
    }
    /**
     * Comprueba el valor de motorEncendido y retorna un String en función de dicho valor
     * @return String
     */
    private fun reiniciado(): String{
        return if (reiniciado){
            "Sí"
        } else{
            "No"
        }
    }

    override fun toString(): String {
        return "$marca $modelo que está $estado. Reiniciado: ${reiniciado()}"
    }
}