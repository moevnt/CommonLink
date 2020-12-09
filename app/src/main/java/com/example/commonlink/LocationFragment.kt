package com.example.commonlink

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import java.net.Inet4Address
import java.util.*


private const val ARG_LOCATION_ID = "location_id"
private const val TAG = "LocationFragment"
class LocationFragment : Fragment() {

	private lateinit var location: Location
	private lateinit var nameField: TextView
	private lateinit var addressField: TextView
	private lateinit var hoursField : TextView
	private lateinit var websiteField : TextView

	private val locationDetailViewModel : LocationDetailViewModel by lazy{
		ViewModelProviders.of(this).get(LocationDetailViewModel::class.java)
	}


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		location = Location()

		val locationId : UUID = arguments?.getSerializable(ARG_LOCATION_ID) as UUID

		locationDetailViewModel.loadLocation(locationId)
	}

	override fun onCreateView(
			inflater: LayoutInflater,
			container: ViewGroup?,
			savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.fragment_location, container, false)

		nameField = view.findViewById(R.id.location_name) as TextView
		addressField = view.findViewById(R.id.location_address) as TextView
		hoursField = view.findViewById(R.id.location_hours) as TextView
		websiteField = view.findViewById(R.id.location_website) as TextView

		updateUI()

		return view
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		locationDetailViewModel.locationLiveData.observe(
				viewLifecycleOwner,
			Observer{
				location -> location?.let {
				this.location = location
				updateUI()
				}
			}
		)
	}

	private fun updateUI(){
		nameField.text = location.name
		addressField.text = location.address
		hoursField.text = location.hours
		websiteField.text = location.website
	}

	override fun onStart() {
		super.onStart()

		val titleWatcher = object : TextWatcher {

			override fun beforeTextChanged(
					sequence: CharSequence?,
					start: Int,
					count: Int,
					after: Int
			) {
				// This space intentionally left blank
			}

			override fun onTextChanged(
					sequence: CharSequence?,
					start: Int,
					before: Int,
					count: Int
			) {
				location.name = sequence.toString()
			}

			override fun afterTextChanged(sequence: Editable?) {
				// This one too
			}
		}

		nameField.addTextChangedListener(titleWatcher)

	}

	companion object{
		fun newInstance(locationId : UUID) : LocationFragment{
			val args = Bundle().apply {
				putSerializable(ARG_LOCATION_ID, locationId)
			}
			return LocationFragment().apply {
				arguments = args
			}
		}
	}

}