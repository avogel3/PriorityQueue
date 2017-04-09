class Node
  attr_accessor :name, :priority

  def initialize name="__empty__", priority=-1
    @name = name
    @priority = priority
  end

end
