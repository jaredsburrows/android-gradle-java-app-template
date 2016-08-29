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
    /**
     * Data in the Adapter.
     */
    protected List<T> mData = new ArrayList<>();

    /**
     * Selected items in the Adapter.
     */
    protected SparseBooleanArray mSelectedItems = new SparseBooleanArray();

    /**
     * Returns the number of elements in the mData.
     *
     * @return the number of elements in the mData.
     */
    @Override
    public int getItemCount() {
        return this.mData.size();
    }

    /**
     * Returns the instance of the mData.
     *
     * @return instance of the mData.
     */
    public List<T> getList() {
        return this.mData;
    }

    /**
     * Returns the element at the specified location in the mData.
     *
     * @param location the index of the element to return.
     * @return the element at the specified location.
     * @throws IndexOutOfBoundsException if {@code location < 0 || location >= size()}
     */
    public T getItem(final int location) {
        return this.mData.get(location);
    }

    /**
     * Searches the mData for the specified object and returns the index of the
     * first occurrence.
     *
     * @param object the object to search for.
     * @return the index of the first occurrence of the object or -1 if the
     * object was not found.
     */
    public int getLocation(final T object) {
        return this.mData.indexOf(object);
    }

    /**
     * Clear the entire adapter using {@link android.support.v7.widget.RecyclerView.Adapter#notifyItemRangeRemoved}.
     */
    public void clear() {
        int size = this.mData.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.mData.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    /**
     * Adds the specified object at the end of the mData.
     *
     * @param object the object to add.
     * @return always true.
     * @throws UnsupportedOperationException if adding to the mData is not supported.
     * @throws ClassCastException            if the class of the object is inappropriate for this
     *                                       mData.
     * @throws IllegalArgumentException      if the object cannot be added to the mData.
     */
    public boolean add(final T object) {
        final boolean added = this.mData.add(object);
        this.notifyItemInserted(this.mData.size() + 1);
        return added;
    }

    /**
     * Adds the objects in the specified collection to the end of the mData. The
     * objects are added in the order in which they are returned from the
     * collection's iterator.
     *
     * @param collection the collection of objects.
     * @return {@code true} if the mData is modified, {@code false} otherwise
     * (i.e. if the passed collection was empty).
     * @throws UnsupportedOperationException if adding to the mData is not supported.
     * @throws ClassCastException            if the class of an object is inappropriate for this
     *                                       mData.
     * @throws IllegalArgumentException      if an object cannot be added to the mData.
     */
    public boolean addAll(final List<T> collection) {
        final boolean added = this.mData.addAll(collection);
        this.notifyItemRangeInserted(0, mData.size() + 1);
        return added;
    }

    /**
     * Inserts the specified object into the mData at the specified location.
     * The object is inserted before the current element at the specified
     * location. If the location is equal to the size of the mData, the object
     * is added at the end. If the location is smaller than the size of the
     * mData, then all elements beyond the specified location are moved by one
     * location towards the end of the mData.
     *
     * @param location the index at which to insert.
     * @param object   the object to add.
     * @throws UnsupportedOperationException if adding to the mData is not supported.
     * @throws ClassCastException            if the class of the object is inappropriate for this
     *                                       mData.
     * @throws IllegalArgumentException      if the object cannot be added to the mData.
     * @throws IndexOutOfBoundsException     if {@code location < 0 || location > size()}
     */
    public void add(final int location, final T object) {
        this.mData.add(location, object);
        this.notifyItemInserted(location);
    }

    /**
     * Replaces the element at the specified location in the mData with the
     * specified object. This operation does not change the size of the mData.
     *
     * @param location the index at which to put the specified object.
     * @param object   the object to insert.
     * @return the previous element at the index.
     * @throws UnsupportedOperationException if replacing elements in the mData is not supported.
     * @throws ClassCastException            if the class of an object is inappropriate for this
     *                                       mData.
     * @throws IllegalArgumentException      if an object cannot be added to the mData.
     * @throws IndexOutOfBoundsException     if {@code location < 0 || location >= size()}
     */
    public T set(final int location, final T object) {
        final T insertedObject = this.mData.set(location, object);
        this.notifyDataSetChanged();
        return insertedObject;
    }

    /**
     * Removes the first occurrence of the specified object from the mData.
     *
     * @param object the object to remove.
     * @return true if the mData was modified by this operation, false
     * otherwise.
     * @throws UnsupportedOperationException if removing from the mData is not supported.
     */
    public boolean remove(final int location, final T object) {
        final boolean removed = this.mData.remove(object);
        this.notifyItemRangeRemoved(location, this.mData.size());
        return removed;
    }

    /**
     * Removes the first occurrence of the specified object from the mData.
     *
     * @param object the object to remove.
     * @return true if the mData was modified by this operation, false
     * otherwise.
     * @throws UnsupportedOperationException if removing from the mData is not supported.
     */
    public boolean remove(final T object) {
        final int location = this.getLocation(object);
        final boolean removed = this.mData.remove(object);
        this.notifyItemRemoved(location);
        return removed;
    }

    /**
     * Removes the object at the specified location from the mData.
     *
     * @param location the index of the object to remove.
     * @return the removed object.
     * @throws UnsupportedOperationException if removing from the mData is not supported.
     * @throws IndexOutOfBoundsException     if {@code location < 0 || location >= size()}
     */
    public T remove(final int location) {
        final T removedObject = this.mData.remove(location);
        this.notifyItemRemoved(location);
        this.notifyItemRangeChanged(location, this.mData.size());
        return removedObject;
    }

    /**
     * Sorts the given list using the given comparator. The algorithm is
     * stable which means equal elements don't get reordered.
     *
     * @throws ClassCastException if any element does not implement {@code Comparable},
     *                            or if {@code compareTo} throws for any pair of elements.
     */
    public void sort(final Comparator<? super T> comparator) {
        Collections.sort(this.mData, comparator);
        this.notifyItemRangeChanged(0, this.getItemCount());
    }

    /**
     * Return the number of selected items.
     *
     * @return Number of selected items.
     */
    public int getItemSelectedCount() {
        return this.mSelectedItems.size();
    }

    /**
     * Return all selected IDs.
     *
     * @return Selected IDs.
     */
    public SparseBooleanArray getSelectedItems() {
        return this.mSelectedItems;
    }

    /**
     * Return all selected items.
     *
     * @return Selected IDs.
     */
    public List<T> getSelectedList() {
        final List<T> list = new ArrayList<>();
        final SparseBooleanArray selectedItems = this.getSelectedItems();
        for (int i = 0; i < selectedItems.size(); i++) {
            final T model = this.getList().get(selectedItems.keyAt(i));
            list.add(model);
        }
        return list;
    }

    /**
     * Remove all current selections.
     */
    public void removeSelections() {
        this.mSelectedItems.clear();
        this.notifyDataSetChanged();
    }

    /**
     * Toggle selection of item.
     *
     * @param location location of view.
     */
    public void toggleSelection(final int location) {
        this.selectItem(location, !this.mSelectedItems.get(location));
    }

    /**
     * Change the current view state to selected.
     *
     * @param location location of view.
     * @param value    True if view is selected.
     */
    public void selectItem(final int location, final boolean value) {
        if (value) {
            this.mSelectedItems.put(location, true);
        } else {
            this.mSelectedItems.delete(location);
        }

        this.notifyItemChanged(location);
    }
}
