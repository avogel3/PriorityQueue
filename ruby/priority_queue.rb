require_relative 'node'
require 'pry'

class PriorityQueue
  attr_reader :queue, :size

  def initialize
    @queue = Array.new(255, Node.new)
    @size = 0
  end
  
  def insert name, priority
    @queue[@size].name = name
    @queue[@size].priority = priority
    @size += 1
    sift_up(0)
  end
  
  def empty?
    @size < 1
  end

  private 
  def sift_up(end_position)
    if (size > 1) 
      node_position = size - 1
      begin 
        # logic Hur
        if(@queue[parentPosition(node_position)].priority > @queue[node_position].priority)
          swap(parenPosition(node_position), node_position)
        end
        node_position -= 1
      end while(node_position > end_position)
    end
  end

  def parentPosition(child_position)
    (child_position - 1) / 2
  end

  def leftChildPosition(parent_position)
    (2 * parent_position) + 1
  end

  def rightChildPosition(parent_position)
    (2 * parent_position) + 2
  end

  def swap(from_position, to_position) 
    temp = @queue[from_position]
    @queue[from_position] = @queue[to_position]
    @queue[to_position] = temp
  end
end
