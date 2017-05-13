require_relative 'node'
require 'pry'

class PriorityQueue
  attr_reader :queue

  def initialize
    @queue = Array.new
  end

  def size
    @queue.size
  end

  def empty?
    size < 1
  end

  def insert(name, priority)
    @queue.push(Node.new(name, priority))
    sift_up
  end

  def remove
    last = size - 1
    swap(0, last)
    min = @queue.pop.name
    sift_down
    return min
  end

  private
  def sift_up
    if size > 1
      current = size - 1
      begin
        parent = (current - 1) / 2
        if(@queue.at(parent).priority > @queue.at(current).priority)
          swap(current, parent)
        end
        current = parent
      end while(current > 0)
    end
  end

  def sift_down
    if(size > 1)
      rootPosition = 0
      endPosition = size - 1
      begin
        child = left_child(rootPosition)
        swapPosition = rootPosition

        if(@queue.at(swapPosition).priority > @queue.at(child).priority)
          swapPosition = child
        end

        if((right_child(rootPosition) <= endPosition) && @queue.at(swapPosition).priority > @queue.at(right_child(rootPosition)).priority)
          swapPosition = right_child(rootPosition)
        end

        return if swapPosition == rootPosition
        swap(rootPosition, swapPosition)
        rootPosition = swapPosition
      end while(left_child(rootPosition) <= endPosition)
    end
  end

  def left_child node
    return (node * 2) + 1
  end

  def right_child node
    return (node * 2) + 2
  end

  def swap(from_position, to_position)
    temp = @queue[from_position]
    @queue[from_position] = @queue[to_position]
    @queue[to_position] = temp
  end
end
