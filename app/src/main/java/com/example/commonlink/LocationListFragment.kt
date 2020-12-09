package com.example.commonlink

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import java.util.*

class LocationListFragment : Fragment(){

	interface Callbacks {
		fun onLocationSelected(locationID : UUID)
	}

	private var callbacks : Callbacks? = null
	private lateinit var locationRecyclerView: RecyclerView
	private var adapter: LocationAdapter? = LocationAdapter(emptyList())

	private val locationListViewModel: LocationListViewModel by lazy {
		ViewModelProviders.of(this).get(LocationListViewModel::class.java)
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
		callbacks = context as Callbacks?
	}

	override fun onDetach() {
		super.onDetach()

		callbacks = null
	}

	override fun onCreateView(
			inflater: LayoutInflater,
			container: ViewGroup?,
			savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.fragment_location_list, container, false)

		locationRecyclerView =
				view.findViewById(R.id.location_recycler_view) as RecyclerView
		locationRecyclerView.layoutManager = LinearLayoutManager(context)

		locationRecyclerView.adapter = adapter
		// updateUI()

		return view
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		locationListViewModel.locationListLiveData.observe(
				viewLifecycleOwner,
				Observer {  locations ->
					locations?.let{
						updateUI(locations)
					}
				}
		)
	}

	private fun updateUI(locations : List<Location>) {
		adapter = LocationAdapter(locations)
		locationRecyclerView.adapter = adapter
	}

	private inner class LocationHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

		private lateinit var location: Location


		private val nameTextView : TextView = itemView.findViewById(R.id.location_name)

		init {
			itemView.setOnClickListener(this)
		}

		fun bind(location: Location) {
			this.location = location
			nameTextView.text = this.location.name
		}

		override fun onClick(v: View) {
			callbacks?.onLocationSelected(location.id)
		}
	}


	private inner class LocationAdapter(var locations: List<Location>)
		: RecyclerView.Adapter<LocationHolder>() {

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
				: LocationHolder {
			val view = layoutInflater.inflate(R.layout.list_item_location, parent, false)
			return LocationHolder(view)
		}

		override fun onBindViewHolder(holder: LocationHolder, position: Int) {
			val location = locations[position]
			holder.bind(location)
		}

		override fun getItemCount() = locations.size
	}

	companion object {
		fun newInstance(): LocationListFragment {
			return LocationListFragment()
		}
	}
}