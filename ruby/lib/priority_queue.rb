require_relative 'node'
require 'pry'

class PriorityQueue
  extend Forwardable
  attr_reader :queue

  def initialize
    @queue = []
  end

  def_delegators :@queue, :empty?, :size

  def insert(name, priority)
    queue.push(Node.new(name, priority))
    sift_up
  end

  def remove
    last = size - 1
    swap(0, last)
    min = queue.pop.name
    sift_down
    min
  end

  private

  def sift_up
    return unless size > 1
    current = size - 1

    begin
      parent = (current - 1) / 2

      if queue.at(parent).priority > queue.at(current).priority
        swap(current, parent)
      end

      current = parent
    end while(current > 0)
  end

  def sift_down
    return unless size > 1
    root_position = 0
    end_position = size - 1

    begin
      child = left_child(root_position)
      swap_position = root_position

      if queue.at(swap_position).priority > queue.at(child).priority
        swap_position = child
      end

      if right_child(root_position) <= end_position &&
         queue.at(swap_position).priority > queue.at(right_child(root_position)).priority
        swap_position = right_child(root_position)
      end

      return if swap_position == root_position

      swap(root_position, swap_position)
      root_position = swap_position
    end while(left_child(root_position) <= end_position)
  end

  def left_child(node_position)
    (node_position * 2) + 1
  end

  def right_child(node_position)
    (node_position * 2) + 2
  end

  def swap(from_position, to_position)
    temp = queue[from_position]
    queue[from_position] = queue[to_position]
    queue[to_position] = temp
  end
end
