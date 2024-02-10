class Telefono(val marca: String, val modelo: String, var estado:String = "Apagado") : EncendidoApagado, DispositivoElectronico {

    var reiniciado: Boolean = false
    init {
        require(marca.isNotBlank()) {"La marca no puede ser un campo vacío"}
        marca.replaceFirstChar { it.uppercase() }
        require(modelo.isNotBlank()) {"El modelo no puede ser un campo vacío"}
        modelo.replaceFirstChar { it.uppercase() }
    }

    override fun encender(): String {
        estado = "Encendido"
        return super.encender()
    }

    override fun apagar(): String {
        estado = "Apagado"
        return super.apagar()
    }

    override fun reiniciar(): String {
        reiniciado = true
        return super.reiniciar()
    }

    fun reiniciado(): String{
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