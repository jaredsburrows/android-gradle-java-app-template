package burrows.apps.lib.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class BaseAdapterTest {

    BaseAdapter<String, TestAdapter.TestViewHolder> adapter = new TestAdapter(); // use String, has equals/compareTo
    String string = "string2"; // unique - string2 < string1, will set sorting later
    String string2 = "string1"; // unique - string1 > string2
    String string3 = "string3"; // unique
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(final String lhs, final String rhs) {
            return lhs.compareTo(rhs);
        }
    };

    @Before
    public void setUp() {
        assertThat(adapter, not(nullValue()));
        assertThat(adapter.getItemCount(), is(0));

        assertThat(adapter.add(string), is(true));
        assertThat(adapter.add(string2), is(true));

        assertThat(adapter.getItemCount(), is(2));
    }

    @After
    public void tearDown() {
        adapter.removeSelections();
        adapter.clear();

        // reset
        setUp();
    }

    @Test
    public void test_getItemCount() {
        assertThat(adapter.getItemCount(), is(2));
    }

    @Test
    public void test_getList() {
        assertThat(adapter.getList(), not(nullValue()));
        assertThat(adapter.getList(), instanceOf(List.class));
    }

    @Test
    public void test_getItem() {
        assertThat(adapter.getItem(0), is(string));
        assertThat(adapter.getItem(1), is(string2));
    }

    @Test
    public void test_getlocation() {
        assertThat(adapter.getlocation(string), is(0));
        assertThat(adapter.getlocation(string2), is(1));
    }

    @Test
    public void test_clear() {
        assertThat(adapter.add(string), is(true));
        assertThat(adapter.add(string2), is(true));

        adapter.clear();

        assertThat(adapter.getItemCount(), is(0));
    }

    @Test
    public void test_add_object() {
        assertThat(adapter.getItemCount(), is(2));

        assertThat(adapter.add(string), is(true));
        assertThat(adapter.add(string2), is(true));

        assertThat(adapter.getItemCount(), is(4));
    }

    @Test
    public void test_add_collection() {
        List<String> list = new ArrayList<>();
        list.add(string3);
        assertThat(adapter.getItemCount(), is(2));

        assertThat(adapter.add(list), is(true));

        assertThat(adapter.getItemCount(), is(3));
    }

    @Test
    public void test_add_location_object() {
        assertThat(adapter.getItemCount(), is(2));

        adapter.add(0, string3);

        assertThat(adapter.getItemCount(), is(3)); // append
        assertThat(adapter.getItem(0), is(string3));
        assertThat(adapter.getItem(1), is(string));
        assertThat(adapter.getItem(2), is(string2));
    }

    @Test
    public void test_set() {
        assertThat(adapter.getItemCount(), is(2));

        adapter.set(1, string3);

        assertThat(adapter.getItemCount(), is(2)); // replace
        assertThat(adapter.getItem(0), is(string));
        assertThat(adapter.getItem(1), is(string3));
    }

    @Test
    public void test_remove_location_object() {
        assertThat(adapter.getItemCount(), is(2));

        assertThat(adapter.remove(0, string), is(true));

        assertThat(adapter.getItemCount(), is(1));
        assertThat(adapter.getItem(0), is(string2));
    }

    @Test
    public void test_remove_object() {
        assertThat(adapter.getItemCount(), is(2));

        assertThat(adapter.add(string3), is(true));
        assertThat(adapter.getItemCount(), is(3));

        assertThat(adapter.remove(string3), is(true));
        assertThat(adapter.getItemCount(), is(2));
    }

    @Test
    public void test_remove_location() {
        assertThat(adapter.getItemCount(), is(2));

        assertThat(adapter.add(string3), is(true));
        assertThat(adapter.getItemCount(), is(3));

        assertThat(adapter.remove(1), is(string2));
        assertThat(adapter.getItemCount(), is(2));
        assertThat(adapter.getItem(0), is(string));
        assertThat(adapter.getItem(1), is(string3));
    }

    @Test
    public void test_sort() {
        assertThat(adapter.getItem(0), is(string));
        assertThat(adapter.getItem(1), is(string2));

        adapter.sort(comparator);

        assertThat(adapter.getItem(0), is(string2));
        assertThat(adapter.getItem(1), is(string));
    }

    @Test
    public void test_getItemSelectedCount() {
        List<String> selected = new ArrayList<>();
        selected.add(string);
        selected.add(string2);

        adapter.selectItem(0, true);
        adapter.selectItem(1, true);

        assertThat(adapter.getItemSelectedCount(), is(2));
        assertThat(adapter.getSelectedList(), is(selected));
    }

    @Test
    public void test_getSelectedItems() {
        List<String> selected = new ArrayList<>();
        selected.add(string);
        selected.add(string2);

        adapter.selectItem(0, true);
        adapter.selectItem(1, true);

        assertThat(adapter.getItemSelectedCount(), is(2));
        assertThat(adapter.getSelectedList(), is(selected));
        assertThat(adapter.getSelectedItems(), not(nullValue())); // SparseBooleanArray does not have equals
        assertThat(adapter.getSelectedItems().get(0), is(true));
        assertThat(adapter.getSelectedItems().get(1), is(true));
    }

    @Test
    public void test_getSelectedList() {
        List<String> selected = new ArrayList<>();
        selected.add(string);
        selected.add(string2);

        adapter.selectItem(0, true);
        adapter.selectItem(1, true);

        assertThat(adapter.getItemSelectedCount(), is(2));
        assertThat(adapter.getSelectedList(), is(selected));
    }

    @Test
    public void test_removeSelections() {
        List<String> selected = new ArrayList<>();

        adapter.removeSelections();

        assertThat(adapter.getItemSelectedCount(), is(0));
        assertThat(adapter.getSelectedList(), is(selected));
    }

    @Test
    public void test_toggleSelection_on() {
        List<String> selected = new ArrayList<>();
        selected.add(string);

        adapter.toggleSelection(0);

        assertThat(adapter.getItemSelectedCount(), is(1));
        assertThat(adapter.getSelectedList(), is(selected));
    }

    @Test
    public void test_toggleSelection_off() {
        List<String> selected = new ArrayList<>();

        adapter.toggleSelection(0);
        adapter.toggleSelection(0);

        assertThat(adapter.getItemSelectedCount(), is(0));
        assertThat(adapter.getSelectedList(), is(selected));
    }

    @Test
    public void test_selectItem_on() {
        List<String> selected = new ArrayList<>();
        selected.add(string);

        adapter.selectItem(0, true);

        assertThat(adapter.getItemSelectedCount(), is(1));
        assertThat(adapter.getSelectedList(), is(selected));
    }

    @Test
    public void test_selectItem_off() {
        List<String> selected = new ArrayList<>();

        adapter.selectItem(0, false);

        assertThat(adapter.getItemSelectedCount(), is(0));
        assertThat(adapter.getSelectedList(), is(selected));
    }

    // stub
    public class TestAdapter extends BaseAdapter<String, TestAdapter.TestViewHolder> {

        @Override
        public TestViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(final TestViewHolder testViewHolder, final int i) {

        }

        public class TestViewHolder extends RecyclerView.ViewHolder {

            public TestViewHolder(final View itemView) {
                super(itemView);
            }
        }
    }
}
