package burrows.apps.example.template.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.SparseBooleanArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("checkstyle:visibilitymodifier")
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    /**
     * Data in the Adapter.
     */
    @NonNull
    protected List<T> data = new ArrayList<>();

    /**
     * Selected items in the Adapter.
     */
    @NonNull
    protected SparseBooleanArray selectedItems = new SparseBooleanArray();

    /**
     * Returns the number of elements in the data.
     *
     * @return the number of elements in the data.
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * Returns the instance of the data.
     *
     * @return instance of the data.
     */
    @NonNull
    public List<T> getList() {
        return data;
    }

    /**
     * Returns the element at the specified location in the data.
     *
     * @param location the index of the element to return.
     * @return the element at the specified location.
     * @throws IndexOutOfBoundsException if {@code location < 0 || location >= size()}
     */
    @NonNull
    public T getItem(int location) {
        return data.get(location);
    }

    /**
     * Searches the data for the specified object and returns the index of the
     * first occurrence.
     *
     * @param object the object to search for.
     * @return the index of the first occurrence of the object or -1 if the
     * object was not found.
     */
    public int getLocation(@NonNull T object) {
        return data.indexOf(object);
    }

    /**
     * Clear the entire adapter using {@link RecyclerView.Adapter#notifyItemRangeRemoved}.
     */
    public void clear() {
        int size = data.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                data.remove(0);
            }

            notifyItemRangeRemoved(0, size);
        }
    }

    /**
     * Adds the specified object at the end of the data.
     *
     * @param object the object to add.
     * @return always true.
     * @throws UnsupportedOperationException if adding to the data is not supported.
     * @throws ClassCastException            if the class of the object is inappropriate for this
     *                                       data.
     * @throws IllegalArgumentException      if the object cannot be added to the data.
     */
    public boolean add(@NonNull T object) {
        final boolean added = data.add(object);
        notifyItemInserted(data.size() + 1);
        return added;
    }

    /**
     * Adds the objects in the specified collection to the end of the data. The
     * objects are added in the order in which they are returned from the
     * collection's iterator.
     *
     * @param collection the collection of objects.
     * @return {@code true} if the data is modified, {@code false} otherwise
     * (i.e. if the passed collection was empty).
     * @throws UnsupportedOperationException if adding to the data is not supported.
     * @throws ClassCastException            if the class of an object is inappropriate for this
     *                                       data.
     * @throws IllegalArgumentException      if an object cannot be added to the data.
     */
    public boolean addAll(@NonNull List<T> collection) {
        final boolean added = data.addAll(collection);
        notifyItemRangeInserted(0, data.size() + 1);
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
     * @throws UnsupportedOperationException if adding to the data is not supported.
     * @throws ClassCastException            if the class of the object is inappropriate for this
     *                                       data.
     * @throws IllegalArgumentException      if the object cannot be added to the data.
     * @throws IndexOutOfBoundsException     if {@code location < 0 || location > size()}
     */
    public void add(int location, @NonNull T object) {
        data.add(location, object);
        notifyItemInserted(location);
    }

    /**
     * Replaces the element at the specified location in the data with the
     * specified object. This operation does not change the size of the data.
     *
     * @param location the index at which to put the specified object.
     * @param object   the object to insert.
     * @return the previous element at the index.
     * @throws UnsupportedOperationException if replacing elements in the data is not supported.
     * @throws ClassCastException            if the class of an object is inappropriate for this
     *                                       data.
     * @throws IllegalArgumentException      if an object cannot be added to the data.
     * @throws IndexOutOfBoundsException     if {@code location < 0 || location >= size()}
     */
    @NonNull
    public T set(int location, @NonNull T object) {
        final T insertedObject = data.set(location, object);
        notifyDataSetChanged();
        return insertedObject;
    }

    /**
     * Removes the first occurrence of the specified object from the data.
     *
     * @param object the object to remove.
     * @return true if the data was modified by this operation, false
     * otherwise.
     * @throws UnsupportedOperationException if removing from the data is not supported.
     */
    public boolean remove(int location, @NonNull T object) {
        final boolean removed = data.remove(object);
        notifyItemRangeRemoved(location, data.size());
        return removed;
    }

    /**
     * Removes the first occurrence of the specified object from the data.
     *
     * @param object the object to remove.
     * @return true if the data was modified by this operation, false
     * otherwise.
     * @throws UnsupportedOperationException if removing from the data is not supported.
     */
    public boolean remove(@NonNull T object) {
        final int location = getLocation(object);
        final boolean removed = data.remove(object);
        notifyItemRemoved(location);
        return removed;
    }

    /**
     * Removes the object at the specified location from the data.
     *
     * @param location the index of the object to remove.
     * @return the removed object.
     * @throws UnsupportedOperationException if removing from the data is not supported.
     * @throws IndexOutOfBoundsException     if {@code location < 0 || location >= size()}
     */
    @NonNull
    public T remove(int location) {
        final T removedObject = data.remove(location);
        notifyItemRemoved(location);
        notifyItemRangeChanged(location, data.size());
        return removedObject;
    }

    /**
     * Sorts the given list using the given comparator. The algorithm is
     * stable which means equal elements don't get reordered.
     *
     * @throws ClassCastException if any element does not implement {@code Comparable},
     *                            or if {@code compareTo} throws for any pair of elements.
     */
    public void sort(@NonNull Comparator<? super T> comparator) {
        Collections.sort(data, comparator);
        notifyItemRangeChanged(0, getItemCount());
    }

    /**
     * Return the number of selected items.
     *
     * @return Number of selected items.
     */
    public int getItemSelectedCount() {
        return selectedItems.size();
    }

    /**
     * Return all selected IDs.
     *
     * @return Selected IDs.
     */
    @NonNull
    public SparseBooleanArray getSelectedItems() {
        return selectedItems;
    }

    /**
     * Return all selected items.
     *
     * @return Selected IDs.
     */
    @NonNull
    public List<T> getSelectedList() {
        final List<T> list = new ArrayList<>();
        final SparseBooleanArray selectedItems = getSelectedItems();
        for (int i = 0; i < selectedItems.size(); i++) {
            final T model = getList().get(selectedItems.keyAt(i));
            list.add(model);
        }
        return list;
    }

    /**
     * Remove all current selections.
     */
    public void removeSelections() {
        selectedItems.clear();
        notifyDataSetChanged();
    }

    /**
     * Toggle selection of item.
     *
     * @param location location of view.
     */
    public void toggleSelection(int location) {
        selectItem(location, !selectedItems.get(location));
    }

    /**
     * Change the current view state to selected.
     *
     * @param location location of view.
     * @param value    True if view is selected.
     */
    public void selectItem(int location, boolean value) {
        if (value) {
            selectedItems.put(location, true);
        } else {
            selectedItems.delete(location);
        }

        notifyItemChanged(location);
    }
}
