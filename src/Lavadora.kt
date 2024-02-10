class Lavadora(val marca: String, var estado: String = "Apagada") : EncendidoApagado, DispositivoElectronico {
    init {
        require(marca.isNotBlank()) {"La marca no puede ser un campo vacío"}
    }

    override fun encender(): String {
        estado = "Encendida"
        return super.encender()
    }
    override fun apagar(): String {
        estado = "Apagada"
        return super.apagar()
    }


    override fun toString(): String {
        return "$marca que está $estado."
    }
}