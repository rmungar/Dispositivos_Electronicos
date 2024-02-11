/**
 * La clase coche hereda de las interfaces EncendidoApagado y DispositivoElectronico
 * La propiedad heredada es:
 * @property marca -> Cadena de caracteres que indica la marca de la lavadora
 * La propiedad propia es:
 * @property estado -> String que indica el estado de la lavadora
 */
class Lavadora(private val marca: String, private var estado: String = "Apagada") : EncendidoApagado, DispositivoElectronico {
    init {
        require(marca.isNotBlank()) {"La marca no puede ser un campo vacío"}
    }
    /**
     * Cambia el valor del estado del objeto y retorna un String
     * @return String
     */
    override fun encender(): String {
        estado = "Encendida"
        return super.encender()
    }
    /**
     * Cambia el valor del estado del objeto y retorna un String
     * @return String
     */
    override fun apagar(): String {
        estado = "Apagada"
        return super.apagar()
    }

    override fun toString(): String {
        return "$marca que está $estado."
    }
}