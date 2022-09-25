package com.android.docpreter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zoho.catalyst.common.ZCatalystUtil
import com.zoho.catalyst.datastore.Column
import com.zoho.catalyst.datastore.ZCatalystSelectQuery
import com.zoho.catalyst.setup.ZCatalystApp
import okio.ByteString.Companion.readByteString
import org.json.JSONObject
import org.json.simple.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class InEffect : Fragment() {
    private lateinit var recylerview:RecyclerView
    private lateinit var aList: ArrayList<prescModal>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in_effect, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val c = Column("filestoreid")
        val s = setOf<Column>(c)
        super.onViewCreated(view, savedInstanceState)
        recylerview = view.findViewById<RecyclerView>(R.id.inEffectRecycler)
        recylerview.layoutManager = LinearLayoutManager(activity)
        aList = arrayListOf<prescModal>()
        aList.add(prescModal("Cold presc","Dr.jithendra","M/A/N"))
        aList.add(prescModal("Fever presc","Dr.jithendra","M/N"))
        aList.add(prescModal("Headache presc","Dr.jithendra","M/A/N"))
        recylerview.adapter = recyclerAdapter(aList)
//        val query = ZCatalystSelectQuery.Builder()
//            .select(s)
//            .from("usertable")
//            .where("name", ZCatalystUtil.Comparator.EQUAL_TO, "9952522935")
//            .build()
//        ZCatalystApp.getInstance().getDataStoreInstance().execute(query,
//            {
//                Toast.makeText(activity,it.toString(),Toast.LENGTH_LONG).show();
//                println("Query executed successfully. $it")
//            },
//            {
//                    exception -> println("Exception occured $exception")
//            })
//

        ZCatalystApp.getInstance().getFileStoreInstance().getFolderInstance(11431000000021647).getFile(
            11431000000021947, //Replace this with your Folder ID and File ID
            {
                    file -> file.download(
                {
                    parseToJSON(it)
                },
                {
                    Toast.makeText(activity,"Something went wrong...",Toast.LENGTH_SHORT).show()
                },
                {   bytesWritten, contentLength, percentage ->
                    println(">> Percentage - $percentage")
                    println(">> Bytes Written - $bytesWritten")
                    println(">> Content Length - $contentLength")
                }
            )
            })
        val helper = SqliteHelper(activity)
        var arList = arrayListOf<String>()
        arList = helper.receipt
        for(i in arList){
            println("listItem "+i)
        }
    }

    private fun parseToJSON(it: InputStream) {
        val helper = SqliteHelper(activity)
        val jObj = FragPager.JParser(it)
        helper.addRecipt(jObj.toString())
        println("myUqRec"+jObj.toString())
        val jRay = jObj.getJSONArray("prescription");
        FragPager.JSolver(jRay)

    }

}