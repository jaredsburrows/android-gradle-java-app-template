package burrows.apps.example.template.adapter;

import android.annotation.TargetApi;
import android.os.Build.VERSION_CODES;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.RoboTestBase;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public class BaseAdapterTest extends RoboTestBase {

    private BaseAdapter<String, TestAdapter.TestViewHolder> sut;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        sut = new TestAdapter(); // use String, has equals/compareTo

        // data
        sut.add(STRING_UNIQUE);
        sut.add(STRING_UNIQUE2);
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();

        sut.removeSelections();
        sut.clear();
    }

    // --------------------------------------------
    // getItemCount()
    // --------------------------------------------

    @Test
    public void testGetItemCountShouldReturnCorrectValues() {
        assertThat(sut.getItemCount()).isEqualTo(2);
    }

    // --------------------------------------------
    // getList()
    // --------------------------------------------

    @Test
    public void testGetListCountShouldReturnCorrectValues() {
        assertThat(sut.getList()).isEqualTo(Arrays.asList(STRING_UNIQUE, STRING_UNIQUE2));
    }

    // --------------------------------------------
    // getItem(final int location)
    // --------------------------------------------

    @Test
    public void testGetItemShouldReturnCorrectValues() {
        assertThat(sut.getItem(1)).isEqualTo(STRING_UNIQUE2);
    }

    // --------------------------------------------
    // getLocation(final T object)
    // --------------------------------------------

    @Test
    public void testGetLocationShouldReturnCorrectValues() {
        assertThat(sut.getLocation(STRING_UNIQUE2)).isEqualTo(1);
    }

    // --------------------------------------------
    // clear()
    // --------------------------------------------

    @Test
    public void testClearShouldClearAdapter() {
        sut.clear();

        assertThat(sut.getItemCount()).isEqualTo(0);
    }

    // --------------------------------------------
    // add(final T object)
    // --------------------------------------------

    @Test
    public void testAddObjectShouldReturnCorrectValues() {
        sut.add(STRING_UNIQUE3);

        assertThat(sut.getList()).isEqualTo(Arrays.asList(STRING_UNIQUE, STRING_UNIQUE2, STRING_UNIQUE3));
    }

    // --------------------------------------------
    // add(final List<T> collection)
    // --------------------------------------------

    @Test
    public void testAddCollectionShouldReturnCorrectValues() {
        final List<String> list = Collections.singletonList(STRING_UNIQUE3);

        sut.addAll(list);

        assertThat(sut.getList()).isEqualTo(Arrays.asList(STRING_UNIQUE, STRING_UNIQUE2, STRING_UNIQUE3));
    }

    // --------------------------------------------
    // add(final int location, final T object)
    // --------------------------------------------

    @Test
    public void testAddLocationObjectShouldReturnCorrectValues() {
        sut.add(0, STRING_UNIQUE3);

        assertThat(sut.getList()).isEqualTo(Arrays.asList(STRING_UNIQUE3, STRING_UNIQUE, STRING_UNIQUE2));
    }

    // --------------------------------------------
    // set(final int location, final T object)
    // --------------------------------------------

    @Test
    public void testSetLocationObjectShouldReturnCorrectValues() {
        sut.set(1, STRING_UNIQUE3);

        assertThat(sut.getList()).isEqualTo(Arrays.asList(STRING_UNIQUE, STRING_UNIQUE3));
    }

    // --------------------------------------------
    // remove(final int location, final T object)
    // --------------------------------------------

    @Test
    public void testRemoveLocationObjectShouldReturnCorrectValues() {
        sut.remove(0, STRING_UNIQUE);

        assertThat(sut.getList()).isEqualTo(Collections.singletonList(STRING_UNIQUE2));
    }

    // --------------------------------------------
    // remove(final T object)
    // --------------------------------------------

    @Test
    public void testRemoveObjectShouldReturnCorrectValues() {
        sut.remove(STRING_UNIQUE);

        assertThat(sut.getList()).isEqualTo(Collections.singletonList(STRING_UNIQUE2));
    }

    // --------------------------------------------
    // remove(final int location)
    // --------------------------------------------

    @Test
    public void testRemoveLocationShouldReturnCorrectValues() {
        sut.remove(0);

        assertThat(sut.getList()).isEqualTo(Collections.singletonList(STRING_UNIQUE2));
    }

    // --------------------------------------------
    // sort(final Comparator<? super T> comparator)
    // --------------------------------------------

    @Test
    public void testSortShouldReturnCorrectValues() {
        sut.sort(new Comparator<String>() {
            @TargetApi(VERSION_CODES.KITKAT)
            @Override
            public int compare(final String lhs, final String rhs) {
                return rhs.length() - lhs.length();
            }
        });

        assertThat(sut.getList()).isEqualTo(Arrays.asList(STRING_UNIQUE2, STRING_UNIQUE));
    }

    // --------------------------------------------
    // getItemSelectedCount()
    // --------------------------------------------

    @Test
    public void testGetItemSelectedCountShouldReturnCorrectValues() {
        sut.selectItem(0, true);
        sut.selectItem(1, true);

        assertThat(sut.getItemSelectedCount()).isEqualTo(2);
    }

    // --------------------------------------------
    // getSelectedItems()
    // --------------------------------------------

    @Test
    public void testGetSelectedItemsShouldReturnCorrectValues() {
        sut.selectItem(0, true);
        sut.selectItem(1, true);

        // does not have equals implemented
        assertThat(sut.getSelectedItems().get(0)).isEqualTo(true);
        assertThat(sut.getSelectedItems().get(1)).isEqualTo(true);
    }

    // --------------------------------------------
    // getSelectedList()
    // --------------------------------------------

    @Test
    public void testGetSelectedListShouldReturnCorrectValues() {
        sut.selectItem(0, true);
        sut.selectItem(1, true);

        assertThat(sut.getSelectedList()).contains(STRING_UNIQUE).contains(STRING_UNIQUE2);
    }

    // --------------------------------------------
    // removeSelections()
    // --------------------------------------------

    @Test
    public void testRemoveSelectionsSelectedCountShouldRemoveCorrectValues() {
        sut.removeSelections();

        assertThat(sut.getItemSelectedCount()).isEqualTo(0);
    }

    @Test
    public void testRemoveSelectionsSelectedListShouldRemoveCorrectValues() {
        sut.removeSelections();

        assertThat(sut.getSelectedList()).isEqualTo(Collections.EMPTY_LIST);
    }

    // --------------------------------------------
    // toggleSelection(final int location)
    // --------------------------------------------

    @Test
    public void testToggleSelectionSelectedCountOnShouldReturnCorrectValues() {
        sut.toggleSelection(0);

        assertThat(sut.getItemSelectedCount()).isEqualTo(1);
    }

    @Test
    public void testToggleSelectionSelectedListOnShouldReturnCorrectValues() {
        sut.toggleSelection(0);

        assertThat(sut.getSelectedList()).isEqualTo(Collections.singletonList(STRING_UNIQUE));
    }

    @Test
    public void testToggleSelectionSelectedCountOffShouldReturnCorrectValues() {
        sut.toggleSelection(0);
        sut.toggleSelection(0);

        assertThat(sut.getItemSelectedCount()).isEqualTo(0);
    }

    @Test
    public void testToggleSelectionSelectedListOffShouldReturnCorrectValues() {
        sut.toggleSelection(0);
        sut.toggleSelection(0);

        assertThat(sut.getSelectedList()).isEqualTo(Collections.EMPTY_LIST);
    }

    // --------------------------------------------
    // selectItem(final int location, final boolean Values)
    // --------------------------------------------

    @Test
    public void testSelectItemSelectedCountOnShouldReturnCorrectValues() {
        sut.selectItem(0, true);

        assertThat(sut.getItemSelectedCount()).isEqualTo(1);
    }

    @Test
    public void testSelectItemSelectedListOnShouldReturnCorrectValues() {
        sut.selectItem(0, true);

        assertThat(sut.getSelectedList()).isEqualTo(Collections.singletonList(STRING_UNIQUE));
    }

    @Test
    public void testSelectItemSelectedCountOffShouldReturnCorrectValues() {
        sut.selectItem(0, false);

        assertThat(sut.getItemSelectedCount()).isEqualTo(0);
    }

    @Test
    public void testSelectItemSelectedListOffShouldReturnCorrectValues() {
        sut.selectItem(0, false);

        assertThat(sut.getSelectedList()).isEqualTo(Collections.EMPTY_LIST);
    }

    // stub
    public static class TestAdapter extends BaseAdapter<String, TestAdapter.TestViewHolder> {
        @Override
        public TestViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(final TestViewHolder testViewHolder, final int i) {
            // nothing
        }

        public static class TestViewHolder extends RecyclerView.ViewHolder {
            public TestViewHolder(final View itemView) {
                super(itemView);
            }
        }
    }
}
