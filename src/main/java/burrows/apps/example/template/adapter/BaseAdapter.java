package burrows.apps.example.template.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
@SuppressWarnings("checkstyle:visibilitymodifier")
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /** Data in the Adapter. */
    protected List<T> data = new ArrayList<>();
    /** Selected items in the Adapter. */
    protected SparseBooleanArray selectedItems = new SparseBooleanArray();

    /**
     * Returns the number of elements in the data.
     *
     * @return the number of elements in the data.
     */
    @Override
    public int getItemCount() {
        return this.data.size();
    }

    /**
     * Returns the instance of the data.
     *
     * @return instance of the data.
     */
    public List<T> getList() {
        return this.data;
    }

    /**
     * Returns the element at the specified location in the data.
     *
     * @param location the index of the element to return.
     *
     * @return the element at the specified location.
     *
     * @exception IndexOutOfBoundsException if {@code location < 0 || location >= size()}
     */
    public T getItem(final int location) {
        return this.data.get(location);
    }

    /**
     * Searches the data for the specified object and returns the index of the
     * first occurrence.
     *
     * @param object the object to search for.
     *
     * @return the index of the first occurrence of the object or -1 if the
     * object was not found.
     */
    public int getLocation(final T object) {
        return this.data.indexOf(object);
    }

    /**
     * Clear the entire adapter using {@link android.support.v7.widget.RecyclerView.Adapter#notifyItemRangeRemoved}.
     */
    public void clear() {
        int size = this.data.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.data.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    /**
     * Adds the specified object at the end of the data.
     *
     * @param object the object to add.
     *
     * @return always true.
     *
     * @exception UnsupportedOperationException if adding to the data is not supported.
     * @exception ClassCastException            if the class of the object is inappropriate for this
     *                                          data.
     * @exception IllegalArgumentException      if the object cannot be added to the data.
     */
    public boolean add(final T object) {
        final boolean added = this.data.add(object);
        this.notifyItemInserted(this.data.size() + 1);
        return added;
    }

    /**
     * Adds the objects in the specified collection to the end of the data. The
     * objects are added in the order in which they are returned from the
     * collection's iterator.
     *
     * @param collection the collection of objects.
     *
     * @return {@code true} if the data is modified, {@code false} otherwise
     * (i.e. if the passed collection was empty).
     *
     * @exception UnsupportedOperationException if adding to the data is not supported.
     * @exception ClassCastException            if the class of an object is inappropriate for this
     *                                          data.
     * @exception IllegalArgumentException      if an object cannot be added to the data.
     */
    public boolean addAll(final List<T> collection) {
        final boolean added = this.data.addAll(collection);
        this.notifyItemRangeInserted(0, data.size() + 1);
        return added;
    }

    /**
     * Inserts the specified object into the data at the specified location.
     * The object is inserted before the current element at the specified
     * location. If the location is equal to the size of the data, the object
     * is added at the end. If the location is smaller than the size of the
     * data, then all elements beyond the specified location are moved by one
     * location towards the end of the data.
     *
     * @param location the index at which to insert.
     * @param object   the object to add.
     *
     * @exception UnsupportedOperationException if adding to the data is not supported.
     * @exception ClassCastException            if the class of the object is inappropriate for this
     *                                          data.
     * @exception IllegalArgumentException      if the object cannot be added to the data.
     * @exception IndexOutOfBoundsException     if {@code location < 0 || location > size()}
     */
    public void add(final int location, final T object) {
        this.data.add(location, object);
        this.notifyItemInserted(location);
    }

    /**
     * Replaces the element at the specified location in the data with the
     * specified object. This operation does not change the size of the data.
     *
     * @param location the index at which to put the specified object.
     * @param object   the object to insert.
     *
     * @return the previous element at the index.
     *
     * @exception UnsupportedOperationException if replacing elements in the data is not supported.
     * @exception ClassCastException            if the class of an object is inappropriate for this
     *                                          data.
     * @exception IllegalArgumentException      if an object cannot be added to the data.
     * @exception IndexOutOfBoundsException     if {@code location < 0 || location >= size()}
     */
    public T set(final int location, final T object) {
        final T insertedObject = this.data.set(location, object);
        this.notifyDataSetChanged();
        return insertedObject;
    }

    /**
     * Removes the first occurrence of the specified object from the data.
     *
     * @param object the object to remove.
     *
     * @return true if the data was modified by this operation, false
     * otherwise.
     *
     * @exception UnsupportedOperationException if removing from the data is not supported.
     */
    public boolean remove(final int location, final T object) {
        final boolean removed = this.data.remove(object);
        this.notifyItemRangeRemoved(location, this.data.size());
        return removed;
    }

    /**
     * Removes the first occurrence of the specified object from the data.
     *
     * @param object the object to remove.
     *
     * @return true if the data was modified by this operation, false
     * otherwise.
     *
     * @exception UnsupportedOperationException if removing from the data is not supported.
     */
    public boolean remove(final T object) {
        final int location = this.getLocation(object);
        final boolean removed = this.data.remove(object);
        this.notifyItemRemoved(location);
        return removed;
    }

    /**
     * Removes the object at the specified location from the data.
     *
     * @param location the index of the object to remove.
     *
     * @return the removed object.
     *
     * @exception UnsupportedOperationException if removing from the data is not supported.
     * @exception IndexOutOfBoundsException     if {@code location < 0 || location >= size()}
     */
    public T remove(final int location) {
        final T removedObject = this.data.remove(location);
        this.notifyItemRemoved(location);
        this.notifyItemRangeChanged(location, this.data.size());
        return removedObject;
    }

    /**
     * Sorts the given list using the given comparator. The algorithm is
     * stable which means equal elements don't get reordered.
     *
     * @exception ClassCastException if any element does not implement {@code Comparable},
     *                               or if {@code compareTo} throws for any pair of elements.
     */
    public void sort(final Comparator<? super T> comparator) {
        Collections.sort(this.data, comparator);
        this.notifyItemRangeChanged(0, this.getItemCount());
    }

    /**
     * Return the number of selected items.
     *
     * @return Number of selected items.
     */
    public int getItemSelectedCount() {
        return this.selectedItems.size();
    }

    /**
     * Return all selected IDs.
     *
     * @return Selected IDs.
     */
    public SparseBooleanArray getSelectedItems() {
        return this.selectedItems;
    }

    /**
     * Return all selected items.
     *
     * @return Selected IDs.
     */
    public List<T> getSelectedList() {
        final List<T> list = new ArrayList<>();
        final SparseBooleanArray sparseBooleanArray = this.getSelectedItems();
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            final T model = this.getList().get(sparseBooleanArray.keyAt(i));
            list.add(model);
        }
        return list;
    }

    /**
     * Remove all current selections.
     */
    public void removeSelections() {
        this.selectedItems.clear();
        this.notifyDataSetChanged();
    }

    /**
     * Toggle selection of item.
     *
     * @param location location of view.
     */
    public void toggleSelection(final int location) {
        this.selectItem(location, !this.selectedItems.get(location));
    }

    /**
     * Change the current view state to selected.
     *
     * @param location location of view.
     * @param value    True if view is selected.
     */
    public void selectItem(final int location, final boolean value) {
        if (value) {
            this.selectedItems.put(location, true);
        } else {
            this.selectedItems.delete(location);
        }

        this.notifyItemChanged(location);
    }
}
