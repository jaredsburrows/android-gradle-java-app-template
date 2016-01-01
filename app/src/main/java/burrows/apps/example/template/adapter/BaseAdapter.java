package burrows.apps.lib.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /** Model in the Adapter. */
    protected List<T> model = new ArrayList<>();
    /** Selected items in the Adapter. */
    protected SparseBooleanArray selectedItems = new SparseBooleanArray();

    /**
     * Returns the number of elements in the model.
     *
     * @return the number of elements in the model.
     */
    @Override
    public int getItemCount() {
        return model.size();
    }

    /**
     * Returns the instance of the model.
     *
     * @return instance of the model.
     */
    public List<T> getList() {
        return this.model;
    }

    /**
     * Returns the element at the specified location in the model.
     *
     * @param location the index of the element to return.
     *
     * @return the element at the specified location.
     *
     * @exception IndexOutOfBoundsException if {@code location < 0 || location >= size()}
     */
    public T getItem(final int location) {
        return this.model.get(location);
    }

    /**
     * Searches the model for the specified object and returns the index of the
     * first occurrence.
     *
     * @param object the object to search for.
     *
     * @return the index of the first occurrence of the object or -1 if the
     * object was not found.
     */
    public int getlocation(final T object) {
        return this.model.indexOf(object);
    }

    /**
     * Clear the entire adapter using {@link android.support.v7.widget.RecyclerView.Adapter#notifyItemRangeRemoved}.
     */
    public void clear() {
        int size = this.model.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.model.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    /**
     * Adds the specified object at the end of the model.
     *
     * @param object the object to add.
     *
     * @return always true.
     *
     * @exception UnsupportedOperationException if adding to the model is not supported.
     * @exception ClassCastException            if the class of the object is inappropriate for this
     *                                          model.
     * @exception IllegalArgumentException      if the object cannot be added to the model.
     */
    public boolean add(final T object) {
        final boolean added = this.model.add(object);
        this.notifyItemInserted(this.model.size() + 1);
        return added;
    }

    /**
     * Adds the objects in the specified collection to the end of the model. The
     * objects are added in the order in which they are returned from the
     * collection's iterator.
     *
     * @param collection the collection of objects.
     *
     * @return {@code true} if the model is modified, {@code false} otherwise
     * (i.e. if the passed collection was empty).
     *
     * @exception UnsupportedOperationException if adding to the model is not supported.
     * @exception ClassCastException            if the class of an object is inappropriate for this
     *                                          model.
     * @exception IllegalArgumentException      if an object cannot be added to the model.
     */
    public boolean add(final List<T> collection) {
        final boolean added = this.model.addAll(collection);
        this.notifyItemRangeInserted(0, model.size() + 1);
        return added;
    }

    /**
     * Inserts the specified object into the model at the specified location.
     * The object is inserted before the current element at the specified
     * location. If the location is equal to the size of the model, the object
     * is added at the end. If the location is smaller than the size of the
     * model, then all elements beyond the specified location are moved by one
     * location towards the end of the model.
     *
     * @param location the index at which to insert.
     * @param object   the object to add.
     *
     * @exception UnsupportedOperationException if adding to the model is not supported.
     * @exception ClassCastException            if the class of the object is inappropriate for this
     *                                          model.
     * @exception IllegalArgumentException      if the object cannot be added to the model.
     * @exception IndexOutOfBoundsException     if {@code location < 0 || location > size()}
     */
    public void add(final int location, final T object) {
        this.model.add(location, object);
        this.notifyItemInserted(location);
    }

    /**
     * Replaces the element at the specified location in the model with the
     * specified object. This operation does not change the size of the model.
     *
     * @param location the index at which to put the specified object.
     * @param object   the object to insert.
     *
     * @return the previous element at the index.
     *
     * @exception UnsupportedOperationException if replacing elements in the model is not supported.
     * @exception ClassCastException            if the class of an object is inappropriate for this
     *                                          model.
     * @exception IllegalArgumentException      if an object cannot be added to the model.
     * @exception IndexOutOfBoundsException     if {@code location < 0 || location >= size()}
     */
    public T set(final int location, final T object) {
        final T insertedObject = this.model.set(location, object);
        this.notifyDataSetChanged();
        return insertedObject;
    }

    /**
     * Removes the first occurrence of the specified object from the model.
     *
     * @param object the object to remove.
     *
     * @return true if the model was modified by this operation, false
     * otherwise.
     *
     * @exception UnsupportedOperationException if removing from the model is not supported.
     */
    public boolean remove(final int location, final T object) {
        final boolean removed = this.model.remove(object);
        this.notifyItemRangeRemoved(location, this.model.size());
        return removed;
    }

    /**
     * Removes the first occurrence of the specified object from the model.
     *
     * @param object the object to remove.
     *
     * @return true if the model was modified by this operation, false
     * otherwise.
     *
     * @exception UnsupportedOperationException if removing from the model is not supported.
     */
    public boolean remove(final T object) {
        final int location = this.getlocation(object);
        final boolean removed = this.model.remove(object);
        this.notifyItemRemoved(location);
        return removed;
    }

    /**
     * Removes the object at the specified location from the model.
     *
     * @param location the index of the object to remove.
     *
     * @return the removed object.
     *
     * @exception UnsupportedOperationException if removing from the model is not supported.
     * @exception IndexOutOfBoundsException     if {@code location < 0 || location >= size()}
     */
    public T remove(final int location) {
        final T removedObject = this.model.remove(location);
        this.notifyItemRemoved(location);
        this.notifyItemRangeChanged(location, this.model.size());
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
        Collections.sort(this.model, comparator);
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
