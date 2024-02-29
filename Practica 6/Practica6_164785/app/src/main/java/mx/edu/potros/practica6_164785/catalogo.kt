package mx.edu.potros.practica6_164785

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class catalogo : AppCompatActivity() {

    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Peliculas>()
    var series = ArrayList<Peliculas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()

        adapter = PeliculaAdapter(this, peliculas)
        seriesAdapter = PeliculaAdapter(this, series)
        var gridPelis: GridView = findViewById(R.id.movies_catalgo)
        var gridSeries: GridView = findViewById(R.id.mseries_catalgo)

        gridPelis.adapter = adapter
        gridSeries.adapter = seriesAdapter
    }

    fun cargarPeliculas() {
        peliculas.add(Peliculas("Demon Slayer", R.drawable.demon, R.drawable.demo, "Demon Slayer: Kimetsu no Yaiba -To the Hashira Training- proyectará por primera vez en cines el episodio 11 del Arco de la Aldea de los Herreros, mostrando así la conclusión de la feroz batalla entre Tanjiro y la Cuarta Luna Creciente, Hatengu, además de cómo Nezuko logra caminar bajo el sol. Le seguirá el episodio 1 del Arco del Entrenamiento de los Pilares, donde veremos el inicio del entrenamiento de los Pilares para prepararse de cara a la próxima batalla contra Muzan Kibutsuji, que se podrá ver por primera vez.", arrayListOf<Cliente>()))
        peliculas.add(Peliculas("Dune", R.drawable.dune, R.drawable.dune2, "Duna: Parte Dos explorará el viaje mítico de Paul Atreides mientras se une con Chani y los Fremen mientras está en un camino de venganza contra los conspiradores que destruyeron a su familia. Enfrentando una elección entre el amor de su vida y el destino del universo conocido, se esfuerza por evitar un futuro terrible que solo él pueda prever." ,arrayListOf<Cliente>()))
        peliculas.add(Peliculas("Ghostbusters Apocalispsis", R.drawable.ghostbusters2, R.drawable.ghostbusters, "En Ghostbusters Apocalipsis Fantasma, regresa la familia Spengler a donde todo empezó – la icónica estación de bomberos en Nueva York – donde hace equipo junto con los Ghostbusters originales que han desarrollado un laboratorio de investigación ultrasecreto para llevar la cacería de fantasmas al siguiente nivel. Pero cuando el descubrimiento de un artefacto antiguo libera una fuerza maligna, los nuevos y viejos Ghostbusters unen sus fuerzas para proteger su hogar y salvar al mundo de una segunda era de hielo.", arrayListOf<Cliente>()))
        peliculas.add(Peliculas("Heroe por encargo", R.drawable.heroexencargo, R.drawable.heroeencargo, "Un ex agente de las fuerzas especiales acepta un trabajo para brindar seguridad a una periodista mientras entrevista a un dictador, pero estalla un golpe militar en medio de la entrevista y se ven obligados a escapar a la jungla donde deben sobrevivir.", arrayListOf<Cliente>()))
        peliculas.add(Peliculas("Vidas Pasadas", R.drawable.vidaspasadas, R.drawable.vidaspasadas1, "Nora y Hae Sung, dos amigos de la infancia profundamente unidos, son separados después de que la familia de Nora emigrara de Corea del Sur. Veinte años después, se reúnen durante una fatídica semana para enfrentarse al amor y al destino.", arrayListOf<Cliente>()))
        peliculas.add(Peliculas("Madame Web", R.drawable.madameweb, R.drawable.madame,"Mientras tanto, en otro universo… En un cambio del típico género, Madame Web cuenta la historia independiente del origen de una de las heroínas más enigmáticas de la editorial Marvel. El thriller de suspenso protagonizado por Dakota Johnson como Cassandra Webb, una paramédico de Manhattan que puede tener habilidades clarividentes. Forzada a enfrentarse a revelaciones de su pasado, ella forja una relación con tres mujeres jóvenes destinadas a tener poderosos futuros… si pueden sobrevivir a un presente mortal.", arrayListOf<Cliente>()))

        series.add(Peliculas("Avatar: La leyenda de Aang", R.drawable.ant, R.drawable.ant2, "La leyenda de Aang sigue al último sobreviviente de los Nómadas del Aire, quien deberá restaurar el equilibrio en el mundo entre las tres naciones restantes: la Tribu del Agua, el Reino Tierra y la Nación del Fuego.", arrayListOf<Cliente>()))
        series.add(Peliculas("Halo", R.drawable.halo, R.drawable.halos, "Una evacuación mortal cambia la guerra del Jefe Maestro con el Covenant. En Reach, un nuevo régimen toma el mando en FLEETCOM. John siente una amenaza inminente cerca. Estreno de temporada.", arrayListOf<Cliente>()))
        series.add(Peliculas("Leveling", R.drawable.sololeveling, R.drawable.sololeveling2, "En un mundo en el que ciertos humanos llamados “cazadores” poseen habilidades mágicas, estos deben luchar contra monstruos para proteger a la raza humana de una aniquilación segura. Un cazador muy débil llamado Sung Jinwoo se encuentra en una lucha en la que solo puede tratar de sobrevivir.", arrayListOf<Cliente>()))
        series.add(Peliculas("Mi adorable demonio", R.drawable.adorabledemonio, R.drawable.adorabledemonios, "Se centra en la vida de Jung Koo Won, un temerario demonio que pierde sus poderes tras conocer a Do Do-Hee, una exitosa empresaria con la que deberá de colaborar para recuperarlos.", arrayListOf<Cliente>()))
    }

    class PeliculaAdapter: BaseAdapter {
        var peliculas = ArrayList<Peliculas>()
        var context: Context? = null

        constructor(context: Context, peliculas: ArrayList<Peliculas>): super() {
            this.peliculas = peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula = peliculas[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.peliculas, null)
            var image = vista.findViewById(R.id.image_movie_cell) as ImageView
            var title = vista.findViewById(R.id.movie_title_cell) as TextView

            image.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)

            vista.setOnClickListener {
                var intent = Intent(context, detalle_pelicula::class.java)
                intent.putExtra("titulo", pelicula.titulo)
                intent.putExtra("imagen", pelicula.image)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("sinopsis", pelicula.sinopsis)
                intent.putExtra("numberSeats",(20-pelicula.seats.size))
                context!!.startActivity(intent)
            }

            return vista
        }
    }
}