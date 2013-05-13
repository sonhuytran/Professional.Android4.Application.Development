package sonhuytran.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListActivity extends Activity implements OnKeyListener {

	private EditText myEditText = null;
	private ListView myListView = null;
	private ArrayList<String> toDoItems = null;
	private ArrayAdapter<String> toDoItemsAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Inflate your view
		setContentView(R.layout.activity_to_do_list);

		// get references to UI widgets
		this.myEditText = (EditText) this.findViewById(R.id.myEditText);
		this.myEditText.setOnKeyListener(this);

		// create an array list of ToDoItems
		this.toDoItems = new ArrayList<String>();
		this.toDoItemsAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, toDoItems);

		// bind the array adapter to the ListView
		this.myListView = (ListView) this.findViewById(R.id.myListView);
		this.myListView.setAdapter(toDoItemsAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_to_do_list, menu);
		return true;
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER
					|| keyCode == KeyEvent.KEYCODE_ENTER) {
				this.toDoItems.add(0, this.myEditText.getText().toString());
				this.toDoItemsAdapter.notifyDataSetChanged();
				this.myEditText.setText("");
				
				return true;
			}
		}
		
		return false;
	}
}
